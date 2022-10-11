package com.maveric.userservice.controller;

import com.maveric.userservice.repository.UserRepository;
import com.maveric.userservice.service.UserServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.maveric.userservice.UserServiceApplicationTests.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static reactor.core.publisher.Mono.when;

import javax.ws.rs.core.MediaType;
@ContextConfiguration(classes=UserController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(UserController.class)
@Tag("Integration test")
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    UserServiceImpl userService;

    @Test
    public void shouldGetUserWhenRequestMadeToGetUser() throws Exception{
        mvc.perform(get(APIV1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    public void shouldGetStatus201WhenRequestMadeToCreateUser() throws Exception
    {
        mvc.perform(post(APIV1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(getUserDto()))
                )
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void shouldGetStatus200WhenRequestMadeToGetUserDetails() throws Exception
    {
        mvc.perform(get(APIV1+"/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    public void shouldGetStatus200WhenRequestMadeToDeleteUser() throws Exception
    {
        mvc.perform(delete(APIV1+"/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void shouldGetStatus200WhenRequestMadeToUpdateUser() throws Exception
    {
        mvc.perform(put(APIV1+"/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(getUserDto()))
                )
                .andExpect(status().isOk())
                .andDo(print());
    }


}
