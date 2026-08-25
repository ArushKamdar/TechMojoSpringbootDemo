package com.example.demo.controllers;

import com.example.demo.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/users")
@RestController
public class UserController {

    private List<User> users = new ArrayList<>();

    public UserController() {
        users.add(new User(1, "Arush"));
        users.add(new User(2, "Arnav"));
    }

    @GetMapping
    public List<User> getUsers(){
        return users;
    }

    @GetMapping(params = "id")
    public User getUser(@RequestParam int id) {
        for(int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        users.add(user);
        return user;
    }

    @PutMapping(params = "id")
    public User updateUser(
            @RequestParam int id,
            @RequestBody User updatedUser) {

        for (int i = 0; i < users.size(); i++) {
            
            User user = users.get(i);
            if (user.getId() == id) {
                user.setName(updatedUser.getName());
                return user;
            }
        }

        return null;
    }

    @DeleteMapping(params = "id")
    public String deleteUser(@RequestParam int id) {

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getId() == id) {
                users.remove(i);
                return "User deleted";
            }
        }
        return "User not found";
    }
}
    










