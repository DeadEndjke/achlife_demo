package com.example.AchLife.service;

import com.example.AchLife.entity.User;
import com.example.AchLife.repostory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return this.userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userByName = this.userRepository.findUserByName(user.getUsername());
        if (userByName.isPresent()){
            throw new IllegalStateException("user_name taken");
        }
        this.userRepository.save(user);
    }

    public void deleteUser(Long id) {
        boolean exist = this.userRepository.existsById(id);

        if(!exist){
            throw new IllegalStateException("user with id = " + id + " not found");
        }

        this.userRepository.deleteById(id);

    }
    public Optional<User> getUserById(Long id){
        return this.userRepository.findById(id);
    }

}
