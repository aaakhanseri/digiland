package com.example.digiland.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// User.java
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "username", unique = true)
    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Game> games = new ArrayList<>();

    // Constructors, getters and setters
    public User() {}

    public User(String username) {
        this.username = username;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}

