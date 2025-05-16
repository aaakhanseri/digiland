package com.example.digiland.model;


import jakarta.persistence.*;

// Level.java
@Entity
@Table(name = "levels")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "level_type", nullable = false)
    private LevelType levelType;

    @Column(name = "level_number", nullable = false)
    private Integer levelNumber;

    // Constructors, getters and setters
    public Level() {}

    public Level(LevelType levelType, Integer levelNumber) {
        this.levelType = levelType;
        this.levelNumber = levelNumber;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public LevelType getLevelType() {
        return levelType;
    }

    public void setLevelType(LevelType levelType) {
        this.levelType = levelType;
    }

    public Integer getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(Integer levelNumber) {
        this.levelNumber = levelNumber;
    }
}
