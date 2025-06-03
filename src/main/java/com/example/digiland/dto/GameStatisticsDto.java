package com.example.digiland.dto;

public class GameStatisticsDto {
    private long totalGamesPlayed;
    private long totalPlayers;
    private long totalTimePlayedSeconds;
    private double averageTimePerGameSeconds;
    private double averageCorrectAnswersPerGame;
    private long totalStarsEarned;

    public long getTotalGamesPlayed() {
        return totalGamesPlayed;
    }

    public void setTotalGamesPlayed(long totalGamesPlayed) {
        this.totalGamesPlayed = totalGamesPlayed;
    }

    public long getTotalPlayers() {
        return totalPlayers;
    }

    public void setTotalPlayers(long totalPlayers) {
        this.totalPlayers = totalPlayers;
    }

    public long getTotalTimePlayedSeconds() {
        return totalTimePlayedSeconds;
    }

    public void setTotalTimePlayedSeconds(long totalTimePlayedSeconds) {
        this.totalTimePlayedSeconds = totalTimePlayedSeconds;
    }

    public double getAverageTimePerGameSeconds() {
        return averageTimePerGameSeconds;
    }

    public void setAverageTimePerGameSeconds(double averageTimePerGameSeconds) {
        this.averageTimePerGameSeconds = averageTimePerGameSeconds;
    }

    public double getAverageCorrectAnswersPerGame() {
        return averageCorrectAnswersPerGame;
    }

    public void setAverageCorrectAnswersPerGame(double averageCorrectAnswersPerGame) {
        this.averageCorrectAnswersPerGame = averageCorrectAnswersPerGame;
    }

    public long getTotalStarsEarned() {
        return totalStarsEarned;
    }

    public void setTotalStarsEarned(long totalStarsEarned) {
        this.totalStarsEarned = totalStarsEarned;
    }

    public double getAverageStarsPerGame() {
        return averageStarsPerGame;
    }

    public void setAverageStarsPerGame(double averageStarsPerGame) {
        this.averageStarsPerGame = averageStarsPerGame;
    }

    public String getMostActivePlayerUsername() {
        return mostActivePlayerUsername;
    }

    public void setMostActivePlayerUsername(String mostActivePlayerUsername) {
        this.mostActivePlayerUsername = mostActivePlayerUsername;
    }

    public long getMostActivePlayerGames() {
        return mostActivePlayerGames;
    }

    public void setMostActivePlayerGames(long mostActivePlayerGames) {
        this.mostActivePlayerGames = mostActivePlayerGames;
    }

    private double averageStarsPerGame;
    private String mostActivePlayerUsername;
    private long mostActivePlayerGames;

    // getters and setters
}
