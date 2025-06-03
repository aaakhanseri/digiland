package com.example.digiland.dto;

import com.example.digiland.model.LevelType;

public class LevelStatsDto {
    private String levelType;
    private int levelNumber;
    private long playersCompleted;
    private double levelCompletionRate;
    private double averageStars;
    private double averageTimeSeconds;

    public LevelStatsDto(String levelType, int levelNumber, long playersCompleted,
                         double averageStars, double averageTimeSeconds) {
        this.levelType = levelType;
        this.levelNumber = levelNumber;
        this.playersCompleted = playersCompleted;
        this.averageStars = averageStars;
        this.averageTimeSeconds = averageTimeSeconds;
        this.levelCompletionRate = 0.0; // Рассчитаем позже
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public long getPlayersCompleted() {
        return playersCompleted;
    }

    public void setPlayersCompleted(long playersCompleted) {
        this.playersCompleted = playersCompleted;
    }

    public double getLevelCompletionRate() {
        return levelCompletionRate;
    }

    public void setLevelCompletionRate(double levelCompletionRate) {
        this.levelCompletionRate = levelCompletionRate;
    }

    public double getAverageStars() {
        return averageStars;
    }

    public void setAverageStars(double averageStars) {
        this.averageStars = averageStars;
    }

    public double getAverageTimeSeconds() {
        return averageTimeSeconds;
    }

    public void setAverageTimeSeconds(double averageTimeSeconds) {
        this.averageTimeSeconds = averageTimeSeconds;
    }


    // Other constructors, getters and setters remain the same
    public LevelStatsDto() {
    }
}

