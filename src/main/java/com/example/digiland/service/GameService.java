package com.example.digiland.service;

import com.example.digiland.dto.*;
import com.example.digiland.model.Game;
import com.example.digiland.model.Level;
import com.example.digiland.model.LevelType;
import com.example.digiland.model.User;
import com.example.digiland.repository.GameRepository;
import com.example.digiland.repository.LevelRepository;
import com.example.digiland.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final LevelRepository levelRepository;
    private final ModelMapper modelMapper;

    public GameDTO saveGameResult(GameRequestDTO request) {
        User user = userRepository.findById(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Level level = levelRepository.findByLevelTypeAndLevelNumber(
                        request.getLevelType(),
                        request.getLevelNumber())
                .orElseGet(() -> levelRepository.save(
                        new Level(request.getLevelType(), request.getLevelNumber())));

        Game game = new Game(
                user,
                level,
                request.getCorrectAnswers(),
                request.getStars(),
                request.getTurn(),
                request.getDurationSeconds()

        );

        Game savedGame = gameRepository.save(game);
        return convertToDTO(savedGame);
    }


    public GameStatisticsDto getStatistics() {
        GameStatisticsDto dto = new GameStatisticsDto();

        dto.setTotalGamesPlayed(gameRepository.getTotalGamesPlayed());
        dto.setTotalPlayers(gameRepository.getTotalPlayers());

        dto.setTotalTimePlayedSeconds(
                Optional.ofNullable(gameRepository.getTotalTimePlayedSeconds()).orElse(0L)
        );

        dto.setAverageTimePerGameSeconds(
                Optional.ofNullable(gameRepository.getAverageTimePerGame()).orElse(0.0)
        );

        dto.setAverageCorrectAnswersPerGame(
                Optional.ofNullable(gameRepository.getAverageCorrectAnswersPerGame()).orElse(0.0)
        );

        dto.setTotalStarsEarned(
                Optional.ofNullable(gameRepository.getTotalStarsEarned()).orElse(0L)
        );

        dto.setAverageStarsPerGame(
                Optional.ofNullable(gameRepository.getAverageStarsPerGame()).orElse(0.0)
        );

        List<Object[]> result = gameRepository.getMostActivePlayer(PageRequest.of(0, 1));;
        if (!result.isEmpty()) {
            Object[] row = result.get(0);
            dto.setMostActivePlayerUsername((String) row[0]);
            dto.setMostActivePlayerGames((Long) row[1]);
        }

        return dto;
    }


    public List<GameDTO> getUserGames(String username) {
        return gameRepository.findByUserUsername(username)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private GameDTO convertToDTO(Game game) {
        return new GameDTO(
                game.getId(),
                new LevelInfoDTO(game.getLevel().getLevelType(), game.getLevel().getLevelNumber()),
                game.getCorrectAnswers(),
                game.getStars(),
                game.getDurationSeconds(),
                game.getTurn()
        );
    }



    public AllLevelsStatsDto getLevelStats() {
        List<LevelStatsDto> stats = gameRepository.getLevelStatsRaw();

        // допустим, общее число игроков:
        long totalPlayers = userRepository.count(); // или получи из UserRepository.count()

        for (LevelStatsDto dto : stats) {
            double completionRate = totalPlayers == 0 ? 0.0 :
                    (100.0 * dto.getPlayersCompleted()) / totalPlayers;
            dto.setLevelCompletionRate(completionRate);
        }

        return new AllLevelsStatsDto(stats);
    }
}