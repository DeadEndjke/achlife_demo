package com.example.AchLife.repostory;

import com.example.AchLife.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {


    @Query("select s from Achievement s where s.name = ?1")
    Optional<Achievement> findAchievementByName(String name);
}
