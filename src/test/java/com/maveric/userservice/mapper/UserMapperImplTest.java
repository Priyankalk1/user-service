package com.maveric.userservice.mapper;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.maveric.userservice.UserServiceApplicationTests.getUser;
import static com.maveric.userservice.UserServiceApplicationTests.getUserDto;
import static org.junit.Assert.assertEquals;

class UserMapperImplTest {
    UserMapperImpl userMapper=new UserMapperImpl();
    @Test
    void map() {
        UserDto userDto=getUserDto();
        User user = userMapper.map(userDto);
        Assertions.assertEquals(getUserDto().getGender(), user.getGender());
        Assertions.assertEquals(getUserDto().get_id(), user.get_id());
    }

    @Test
    void testMap() {
        User user=getUser();
        UserDto userdto = userMapper.map(user);
        Assertions.assertEquals(getUser().getGender(), userdto.getGender());
        Assertions.assertEquals(getUser().get_id(), userdto.get_id());
    }

    @Test
    void mapToModel() {

        List<User> users = userMapper.mapToModel(Arrays.asList(getUserDto(),getUserDto()));
        Assertions.assertEquals(2, users.size());
    }

    @Test
    void mapToDto() {
        List<UserDto> users = userMapper.mapToDto(Arrays.asList(getUser(),getUser()));
        Assertions.assertEquals(2, users.size());
    }
}