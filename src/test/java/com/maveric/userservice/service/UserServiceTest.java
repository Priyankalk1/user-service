package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.enumeration.Gender;
import com.maveric.userservice.mapper.UserMapper;
import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.maveric.userservice.UserServiceApplicationTests.getUser;
import static com.maveric.userservice.UserServiceApplicationTests.getUserDto;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository repository;

    @Mock
    private UserMapper mapper;

    @Mock
    private Page pageResult;


    @Test
    public void testCreateUser() throws Exception{
        when(mapper.map(any(UserDto.class))).thenReturn(getUser());
        when(mapper.map(any(User.class))).thenReturn(getUserDto());
        when(repository.save(any())).thenReturn(getUser());
        UserDto userDto = service.createUser(getUserDto());
        assertSame(userDto.getFirstName(), getUser().getFirstName());
    }

    @Test
    public void testGetUsers() {
        Page<User> pagedResponse = new PageImpl(Arrays.asList(getUser(),getUser()));
        when(repository.findAll(any(Pageable.class))).thenReturn(pagedResponse);
        when(pageResult.hasContent()).thenReturn(true);
        when(pageResult.getContent()).thenReturn(Arrays.asList(getUser(),getUser()));
        when(mapper.mapToDto(any())).thenReturn(Arrays.asList(getUserDto(),getUserDto()));
        List<UserDto> users = service.getUsers(1,1);

        assertEquals("manisha", users.get(0).getFirstName());
        assertEquals(Gender.MALE, users.get(1).getGender());
    }

    @Test
    public void testGetUserById() {
        when(repository.findById(2)).thenReturn(Optional.of(getUser()));
        when(mapper.map(any(User.class))).thenReturn(getUserDto());

        UserDto userDto = service.getUserDetails(2);

        assertSame(userDto.getFirstName(),getUserDto().getFirstName());
    }

    @Test
    public void testDeleteUserById() {

        when(repository.findById(2)).thenReturn(Optional.of(getUser()));
        willDoNothing().given(repository).deleteById(2);

        String userDto = service.deleteUser(2);

        assertSame( "User deleted successfully.",userDto);
    }

}