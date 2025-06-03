package com.example.digiland.repository;

import com.example.digiland.dto.LevelStatsDto;
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



    @Query("SELECT COUNT(g) FROM Game g")
    long getTotalGamesPlayed();

    @Query("SELECT COUNT(DISTINCT g.user.username) FROM Game g")
    long getTotalPlayers();

    @Query("SELECT SUM(g.durationSeconds) FROM Game g")
    Long getTotalTimePlayedSeconds();

    @Query("SELECT AVG(g.durationSeconds) FROM Game g")
    Double getAverageTimePerGame();

    @Query("SELECT AVG(g.correctAnswers) FROM Game g")
    Double getAverageCorrectAnswersPerGame();

    @Query("SELECT SUM(g.stars) FROM Game g")
    Long getTotalStarsEarned();

    @Query("SELECT AVG(g.stars) FROM Game g")
    Double getAverageStarsPerGame();

    @Query("""
       SELECT g.user.username, COUNT(g) as gameCount
       FROM Game g
       GROUP BY g.user.username
       ORDER BY gameCount DESC
       """)
    List<Object[]> getMostActivePlayer(Pageable pageable);



    @Query("""
    SELECT new com.example.digiland.dto.LevelStatsDto(
        CAST(l.levelType AS string),
        l.levelNumber,
        COUNT(DISTINCT g.user.username),
        AVG(g.stars),
        AVG(g.durationSeconds)
    )
    FROM Game g
    JOIN g.level l
    GROUP BY l.levelType, l.levelNumber
""")
    List<LevelStatsDto> getLevelStatsRaw();

}