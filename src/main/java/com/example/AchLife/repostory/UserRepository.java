package com.example.AchLife.repostory;

import com.example.AchLife.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select s from User s where s.username = ?1")
    Optional<User> findUserByName(String username);
}
