package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;

import com.example.demo.User;
import com.example.demo.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/users")
@RestController
public class UserController {


    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping(params = "id")
    public User getUser(@RequestParam int id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }


    @PutMapping(params = "id")
    public User updateUser(
            @RequestParam int id,
            @RequestBody User updatedUser) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        user.setName(updatedUser.getName());

        return userRepository.save(user);
    }

    @DeleteMapping(params = "id")
    public String deleteUser(@RequestParam int id) {
        userRepository.deleteById(id);
        return "User deleted";
    }
}
    










