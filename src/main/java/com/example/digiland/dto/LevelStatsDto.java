package com.example.digiland.dto;

public class LevelStatsDto {
    private String levelType;
    private int levelNumber;
    private long playersCompleted;
    private double levelCompletionRate;
    private double averageStars;
    private double averageTimeSeconds;

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
}

