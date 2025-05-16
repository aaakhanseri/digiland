package com.example.digiland.dto;

import java.util.List;

public class UserDTO {
    private String username;
    private List<GameDTO> games;

    // Конструкторы
    public UserDTO() {}

    public UserDTO(String username, List<GameDTO> games) {
        this.username = username;
        this.games = games;
    }

    // Геттеры и сеттеры
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<GameDTO> getGames() {
        return games;
    }

    public void setGames(List<GameDTO> games) {
        this.games = games;
    }
}