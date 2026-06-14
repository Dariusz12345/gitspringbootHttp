package com.example.nauka1.service;

import com.example.nauka1.repository.UserRepository;
import model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service

public class UserService {

    private final UserRepository userRepository;



    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }


    public void deleteUser(int id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user);
    }

//    public void deleteUser(int id) {
//        userRepository.deleteById(id);
//    }

}
