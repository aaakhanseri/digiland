package com.example.digiland.service;

import com.example.digiland.dto.GameDTO;
import com.example.digiland.dto.GameRequestDTO;
import com.example.digiland.dto.LevelInfoDTO;
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
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
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
}