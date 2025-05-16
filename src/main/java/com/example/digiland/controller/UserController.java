package com.example.digiland.controller;

import com.example.digiland.model.User;
import com.example.digiland.repository.UserStarsProjection;
import com.example.digiland.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestParam String username) {
        try {
            User user = userService.registerUser(username);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<UserStarsProjection>> getLeaderboard() {
        return ResponseEntity.ok(userService.getTop4UsersByStars());
    }
}