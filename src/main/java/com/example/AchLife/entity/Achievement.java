package com.example.AchLife.entity;

import com.example.AchLife.enums.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String description;
    @Column(nullable = false)
    private String image;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "favAchievement", orphanRemoval = true)
    private List<User> favUser = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "achievements",fetch = FetchType.EAGER)
    private List<User> users;

    public Achievement(String name, String description, String image, Type type) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.type = type;
    }
}
