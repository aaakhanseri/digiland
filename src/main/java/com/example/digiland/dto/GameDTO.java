package com.example.digiland.dto;

public class GameDTO {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LevelInfoDTO getLevel() {
        return level;
    }

    public void setLevel(LevelInfoDTO level) {
        this.level = level;
    }

    public Integer getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(Integer correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Integer getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(Integer durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public String getFormattedDuration() {
        return formattedDuration;
    }

    public void setFormattedDuration(String formattedDuration) {
        this.formattedDuration = formattedDuration;
    }

    private Long id;
    private LevelInfoDTO level;
    private Integer correctAnswers;
    private Integer stars;
    private Integer durationSeconds;
    private Integer turn;
    private String formattedDuration;

    // Конструкторы
    public GameDTO() {}

    public GameDTO(Long id, LevelInfoDTO level, Integer correctAnswers,
                   Integer stars, Integer durationSeconds, Integer turn) {
        this.id = id;
        this.level = level;
        this.correctAnswers = correctAnswers;
        this.stars = stars;
        this.durationSeconds = durationSeconds;
        this.turn = turn;
        this.formattedDuration = formatDuration(durationSeconds);
    }

    // Метод для форматирования времени


    // Метод для форматирования времени
    private String formatDuration(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return minutes + " мин " + seconds + " сек";
    }


}