package com.example.digiland.repository;

import com.example.digiland.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByUserUsername(String username);

    @Query(value = """
        SELECT u.username as username, COALESCE(SUM(g.stars), 0) as totalStars 
        FROM users u
        LEFT JOIN games g ON u.username = g.user_username
        GROUP BY u.username
        ORDER BY totalStars DESC
        LIMIT :limit""",
            nativeQuery = true)
    List<UserStarsProjection> findTopUsersByStars(@Param("limit") int limit);
}