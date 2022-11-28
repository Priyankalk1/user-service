package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> getUsers(Integer page, Integer pageSize);
    public UserDto createUser(UserDto userDto);

    public UserDto getUserDetails(String userId);

    public String deleteUser(String userId);

    public UserDto getUserDetailsByEmail(String emailId);

    public UserDto updateUser(String userId, UserDto userDto);
}
