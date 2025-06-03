package com.example.digiland.controller;

import com.example.digiland.dto.AllLevelsStatsDto;
import com.example.digiland.dto.GameDTO;
import com.example.digiland.dto.GameRequestDTO;
import com.example.digiland.dto.GameStatisticsDto;
import com.example.digiland.model.Game;
import com.example.digiland.model.LevelType;
import com.example.digiland.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @PostMapping
    public ResponseEntity<GameDTO> saveGame(@RequestBody GameRequestDTO request) {
        GameDTO savedGame = gameService.saveGameResult(request);
        return ResponseEntity.ok(savedGame);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<GameDTO>> getUserGames(@PathVariable String username) {
        List<GameDTO> games = gameService.getUserGames(username);
        return ResponseEntity.ok(games);
    }

    @GetMapping("/global")
    public ResponseEntity<GameStatisticsDto> getGlobalStats() {
        return ResponseEntity.ok(gameService.getStatistics());
    }


    @GetMapping("/levels")
    public ResponseEntity<AllLevelsStatsDto> getLevelStats() {
        return ResponseEntity.ok(gameService.getLevelStats());
    }
}