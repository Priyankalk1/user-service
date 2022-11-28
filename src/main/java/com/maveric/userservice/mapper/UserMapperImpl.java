package com.maveric.userservice.mapper;


import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User map(UserDto userDto) {
        return new User(
                userDto.get_id(),
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
                user.get_id(),
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
    public List<User> mapToModel(List<UserDto> userDtos) {
        if(!userDtos.isEmpty())
            return userDtos.stream().map(user -> new User(
                    user.get_id(),
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
            )).toList();
        else
            return Collections.<User>emptyList();
    }

    @Override
    public List<UserDto> mapToDto(List<User> users) {
        if(!users.isEmpty())
            return users.stream().map(userDto -> new UserDto(
                    userDto.get_id(),
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
            )).toList();
        else
            return Collections.<UserDto>emptyList();
    }
}
