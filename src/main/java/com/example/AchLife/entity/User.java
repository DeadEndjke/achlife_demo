package com.example.AchLife.entity;


import com.example.AchLife.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String hashPass;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public User(String username, String hashPass,  Achievement favAchievement, List<Achievement> achievements, Role role) {
        this.username = username;
        this.hashPass = hashPass;
        this.favAchievement = favAchievement;
        this.achievements = achievements;
        this.role = role;
    }

    public User(String username, String hashPass, Role role) {
        this.username = username;
        this.hashPass = hashPass;
        this.role = role;
    }



    @ManyToOne(fetch = FetchType.EAGER)
    private Achievement favAchievement;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Achievement> achievements;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return this.hashPass;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
