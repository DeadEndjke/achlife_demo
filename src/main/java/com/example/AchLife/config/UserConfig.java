package com.example.AchLife.config;


import com.example.AchLife.entity.Achievement;
import com.example.AchLife.entity.User;
import com.example.AchLife.enums.Role;
import com.example.AchLife.enums.Type;
import com.example.AchLife.repostory.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){

        return args -> {



            Achievement ach1 = new Achievement(
                    "В ТИХОМ ОМУТЕ…",
                    "Вы получили лицензию на оружие",
                    "",
                    Type.SKILLS
            );
            Achievement ach2 = new Achievement(
                    "ВЕТЕРАН НЕДРОЧАБРЯ",
                    "Вы успешно выполнили челлендж недрочабрь в возрасте старше 16 лет",
                    "",
                    Type.REGULAR
            );
            Achievement ach3 = new Achievement(
                    "ДУХИ ПЕРЕСТАЛИ СО МНОЙ ГОВОРИТЬ",
                    "Вы встречались/встречаетесь с девушкой",
                    "",
                    Type.RELATIONSHIPS
            );
            Achievement ach4 = new Achievement(
                    "ПОНИМАЕТЕ, Я СТУДЕНТ…",
                    "Вы поступили в университет",
                    "",
                    Type.EDUCATION
            );
            Achievement ach5 = new Achievement(
                    "Я УСТАЛ, Я УХОЖУ",
                    "Вы уволились с первой работы",
                    "",
                    Type.JOB
            );

            User user1 = new User("DeadEndjke", "73ibunot", ach3, List.of(ach3, ach4, ach5), Role.MODERATOR);
            User user2 = new User("winning_smile", "hui213", ach1, List.of(ach1, ach2), Role.ADMIN);

            try{
                repository.saveAll(List.of(user1, user2));
            } catch (Exception e){
                repository.saveAll(List.of());
            }

        };
    }
}
