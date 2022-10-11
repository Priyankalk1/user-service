package com.maveric.userservice.mapper;


import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User map(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getMiddleName(),
                userDto.getPhoneNumber(),
                userDto.getEmail(),
                userDto.getAddress(),
                userDto.getDateOfBirth(),
                userDto.getGender(),
                userDto.getRole(),
                userDto.getPassword()

        );
    }

    @Override
    public UserDto map(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getMiddleName(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getAddress(),
                user.getDateOfBirth(),
                user.getGender(),
                user.getRole(),
                user.getPassword()
        );
    }

    @Override
    public List<User> map(List<UserDto> userRespons) {
        List<User> list = new ArrayList<User>(userRespons.size());
        for(UserDto userDto: userRespons)
        {
            list.add(map(userDto));
        }
        return list;
    }

    @Override
    public List<UserDto> mapToDto(List<User> users) {
        return users.stream().map(userDto -> new UserDto(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getMiddleName(),
                userDto.getLastName(),
                userDto.getPhoneNumber(),
                userDto.getEmail(),
                userDto.getAddress(),
                userDto.getDateOfBirth(),
                userDto.getGender(),
                userDto.getRole(),
                userDto.getPassword()
        )).toList();
    }
}
