package com.maveric.userservice.controller;

import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import com.maveric.userservice.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserServiceImpl userService;
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        try {
            List<User> list = userRepository.findAll();

            if (list.isEmpty() || list.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user ) {
            return userService.createUser(user);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserDetails(@PathVariable("id") Integer id) {

        return (ResponseEntity<User>) userService.getUserDetails(id);

    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable("id") Integer id, @RequestBody User user) {

        return userService.updateUser(id,user);

    }
    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable("id") Integer id) {

        return userService.deleteUser(id);

    }

    @GetMapping(" /users/getUserByEmail/{emailId}")
        public ResponseEntity<List<User>> getUserDetailsByEmail( String email) {
            try {
                List<User> users = new ArrayList<User>();
                if (email == null)
                    userRepository.findAll().forEach(users::add);
                else
                    userRepository.findByEmail(email).forEach(users::add);
                if (users.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(users, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

}


