package com.maveric.userservice.controller;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class UserController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;
    /* Returns list of All Users */
    @GetMapping("users")
    public ResponseEntity<List<UserDto>> getUsers(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer pageSize){
        List<UserDto> userRespons = userService.getUsers(page,pageSize);
        log.info("API call returning list of All Users");
        return new ResponseEntity<>(userRespons, HttpStatus.OK);
    }

    /* Saving new user */
    @PostMapping("users")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        log.info("API call to create a new User");
        UserDto userDtoResponse = userService.createUser(userDto);
        log.info("User information Created successfully");
        userDtoResponse.setPassword(null);
        return new ResponseEntity<>(userDtoResponse, HttpStatus.CREATED);
    }

    /* Returns list of user details by userId */
    @GetMapping("users/{userId}")
    public ResponseEntity<UserDto> getUserDetails(@PathVariable String userId) {
        log.info("API call returning list of User details for the given valid UserId");
        UserDto userDtoResponse = userService.getUserDetails(userId);
        return new ResponseEntity<>(userDtoResponse, HttpStatus.OK);

    }
    /* Deleting user by userId */
    @DeleteMapping("users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        log.info("API call to delete User based on UserId");
        String result = userService.deleteUser(userId);
        log.info("User deleted successfully");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    /* Update User by UserId */
    @PutMapping("users/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String userId, @RequestBody UserDto userDto) {
        log.info("API call to Update User for valid userId");
            UserDto userDto1 = userService.updateUser(userId, userDto);
            log.info("User information Updated successfully");
            return new ResponseEntity<>(userDto1, HttpStatus.OK);
        }
    /* Returns list details by emailId */
    @GetMapping("users/getUserByEmail/{emailId}")
    public ResponseEntity<UserDto> getUserDetailsByEmail(@PathVariable String emailId) {
        log.info("API call returning list of User details for the given valid emailId");
        UserDto userDtoResponse = userService.getUserDetailsByEmail(emailId);
        return new ResponseEntity<>(userDtoResponse, HttpStatus.OK);

    }
}
