package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;

import java.util.List;

public interface UserService {
    public List<UserDto> getUsers(Integer page, Integer pageSize);
    public UserDto createUser(UserDto userDto);

    public UserDto getUserDetails(Integer userId);

    public String deleteUser(Integer userId);

    public UserDto getUserDetailsByEmail(String emailId);

    public UserDto updateUser(Integer userId, UserDto userDto);
}
