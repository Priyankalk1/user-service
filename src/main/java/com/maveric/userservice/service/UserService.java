package com.maveric.userservice.service;

import com.maveric.userservice.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User createUser(User user);

    List<User> getUserDetails(Integer id);

    User updateUser(Integer id, User user);

    public String deleteUser(Integer id);

   User getUserDetailsByEmail(String email);
}
