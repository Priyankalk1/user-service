package com.maveric.userservice.controller;

import com.maveric.userservice.model.User;
import com.maveric.userservice.service.UserService;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/addUser")
    public List<User> addUser(@RequestBody List<User> users) {
        return userService.saveUser(users);
    }

    @GetMapping("/user")
    public List<User> findAllUser() {
        return userService.getUser();
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }


    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.userUpdate(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

}


