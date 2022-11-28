package com.maveric.userservice.mapper;
import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="User")
public interface UserMapper {

    User map(UserDto userDto);

    UserDto map(User user);

    List<User> mapToModel (List<UserDto> userDtos);

    List<UserDto> mapToDto (List<User> users);
}
