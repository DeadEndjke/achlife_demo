package com.example.AchLife.controller;


import com.example.AchLife.entity.Achievement;
import com.example.AchLife.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/achievements")
public class AchievementController {
    private final AchievementService achievementService;

    @Autowired
    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @GetMapping
    public List<Achievement> getAchivements(){
        return this.achievementService.getAchievements();
    }

    @PostMapping
    public void addNewAchievement(@RequestBody Achievement achievement){
        this.achievementService.addNewAchievement(achievement);
    }

    @DeleteMapping(path = "{achievementId}")
    public void deleteRole(Long achievementId){
        this.achievementService.deleteAchievement(achievementId);
    }

    @GetMapping(path = "{achievementId}")
    public Optional<Achievement> getAchivementById(@PathVariable Long achievementId){
        return this.achievementService.getAchievementById(achievementId);
    }
}
