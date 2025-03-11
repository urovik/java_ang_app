package com.example.demo.controller;

import com.example.demo.repository.User;
import com.example.demo.service.UserService;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
@RequestMapping(path = "users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }
    
    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        userService.delete(id);
    }
    
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody User user) {
        userService.update(id, user.getEmail(), user.getName());
    }
}
