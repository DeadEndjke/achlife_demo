package com.example.AchLife.service;


import com.example.AchLife.entity.Achievement;
import com.example.AchLife.repostory.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AchievementService {

    private final AchievementRepository achievementRepository;

    @Autowired
    public AchievementService(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    public List<Achievement> getAchievements(){
        return this.achievementRepository.findAll();
    }

    public void addNewAchievement(Achievement achievement) {
        Optional<Achievement> achievementByName = this.achievementRepository.findAchievementByName(achievement.getName());
        if (achievementByName.isPresent()){
            throw new IllegalStateException("role_name taken");
        }
        this.achievementRepository.save(achievement);
    }

    public void deleteAchievement(Long id) {
        boolean exist = this.achievementRepository.existsById(id);

        if(!exist){
            throw new IllegalStateException("achievement with id = " + id + " not found");
        }

        this.achievementRepository.deleteById(id);

    }

    public Optional<Achievement> getAchievementById(Long id){
        return this.achievementRepository.findById(id);
    }
}
