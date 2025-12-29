package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoCustomRepository {

    @Query("SELECT t FROM Todo t LEFT JOIN FETCH t.user u ORDER BY t.modifiedAt DESC")
    Page<Todo> findAllByOrderByModifiedAtDesc(Pageable pageable);

/*    @Query("SELECT t FROM Todo t " +
            "LEFT JOIN t.user " +
            "WHERE t.id = :todoId")
    Optional<Todo> findByIdWithUser(@Param("todoId") Long todoId);*/

    // 날씨만
    @Query("""
                SELECT t
                FROM Todo t
                WHERE t.weather = :weather
                ORDER BY t.modifiedAt DESC
            """)
    Page<Todo> findByWeather(@Param("weather") String weather, Pageable pageable);

    // 시작일 종료일
    @Query("""
                SELECT t
                FROM Todo t
                WHERE t.modifiedAt BETWEEN :start AND :end
                ORDER BY t.modifiedAt DESC
            """)
    Page<Todo> findByModifiedAtBetween(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end, Pageable pageable);

    // 시작일
    @Query("""
                SELECT t
                FROM Todo t
                WHERE t.modifiedAt >= :start
                ORDER BY t.modifiedAt DESC
            """)
    Page<Todo> findByModifiedAtAfter(@Param("start") LocalDateTime start, Pageable pageable);

    // 종료일
    @Query("""
                SELECT t
                FROM Todo t
                WHERE t.modifiedAt <= :end
                ORDER BY t.modifiedAt DESC
            """)
    Page<Todo> findByModifiedAtBefore(@Param("end") LocalDateTime end, Pageable pageable);

    // 날씨 + 시작일 종료일
    @Query("""
                SELECT t
                FROM Todo t
                WHERE t.weather = :weather
                AND t.modifiedAt BETWEEN :start AND :end
                ORDER BY t.modifiedAt DESC
            """)
    Page<Todo> findByWeatherAndModifiedAtBetween(@Param("weather") String weather, @Param("start") LocalDateTime start, @Param("end") LocalDateTime end, Pageable pageable);


    // 날씨 + 시작일
    @Query("""
                SELECT t
                FROM Todo t
                WHERE t.weather = :weather
                AND t.modifiedAt >= :start
                ORDER BY t.modifiedAt DESC
            """)
    Page<Todo> findByWeatherAndModifiedAtAfter(@Param("weather") String weather, @Param("start") LocalDateTime start, Pageable pageable);

    // 날씨 + 종료일
    @Query("""
                SELECT t
                FROM Todo t
                WHERE t.weather = :weather
                AND t.modifiedAt <= :end
                ORDER BY t.modifiedAt DESC
            """)
    Page<Todo> findByWeatherAndModifiedAtBefore(@Param("weather") String weather, @Param("end") LocalDateTime end, Pageable pageable);
}
