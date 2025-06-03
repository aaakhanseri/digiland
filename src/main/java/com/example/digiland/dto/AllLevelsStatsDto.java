package com.example.digiland.dto;

import java.util.List;

public class AllLevelsStatsDto {
    private List<LevelStatsDto> levels;

    public AllLevelsStatsDto(List<LevelStatsDto> levels) {
        this.levels = levels;
    }

    public List<LevelStatsDto> getLevels() {
        return levels;
    }
}

