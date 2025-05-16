package com.example.digiland.service;

import com.example.digiland.model.User;
import com.example.digiland.repository.GameRepository;
import com.example.digiland.repository.UserRepository;
import com.example.digiland.repository.UserStarsProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final GameRepository gameRepository; // Добавляем GameRepository

    @Autowired
    public UserService(UserRepository userRepository, GameRepository gameRepository) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository; // Инициализируем gameRepository
    }

    public User registerUser(String username) {
        if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username already exists");
        }
        User user = new User(username);
        return userRepository.save(user);
    }

    public List<UserStarsProjection> getTop4UsersByStars() {
        return gameRepository.findTopUsersByStars(4);
    }
}

