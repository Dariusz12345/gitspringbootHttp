package com.example.nauka1.controller;

import com.example.nauka1.service.UserService;
import model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

    private final UserService userService;

    public UserController (UserService userService) {
    this.userService = userService;
    }

    @GetMapping
    public List<User>  getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {

        return userService.addUser(user);
    }


    @PostMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable int id) {

        userService.deleteUser(id);

        return "redirect:/users";
    }

}
