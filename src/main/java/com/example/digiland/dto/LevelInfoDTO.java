package com.example.digiland.dto;

import com.example.digiland.model.LevelType;

public class LevelInfoDTO {
    private String levelType;
    private Integer levelNumber;

    // Конструкторы и геттеры/сеттеры
    public LevelInfoDTO() {}

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }

    public Integer getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(Integer levelNumber) {
        this.levelNumber = levelNumber;
    }

    public LevelInfoDTO(LevelType levelType, Integer levelNumber) {
        this.levelType = levelType.toString();
        this.levelNumber = levelNumber;
    }

}
