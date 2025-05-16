package com.example.digiland.repository;
import com.example.digiland.model.Level;
import com.example.digiland.model.LevelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// LevelRepository.java
public interface LevelRepository extends JpaRepository<Level, Long> {
    Optional<Level> findByLevelTypeAndLevelNumber(LevelType levelType, Integer levelNumber);
}