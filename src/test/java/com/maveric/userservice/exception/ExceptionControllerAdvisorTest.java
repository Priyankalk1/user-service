package com.maveric.userservice.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maveric.userservice.repository.UserRepository;
import com.maveric.userservice.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.maveric.userservice.UserServiceApplicationTests.APIV1;
import static com.maveric.userservice.UserServiceApplicationTests.getUserDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes= ExceptionControllerAdvisor.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(ExceptionControllerAdvisor.class)
public class ExceptionControllerAdvisorTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void whenRequestSyntaxNotValidShouldGetError400WhenRequestMadeToCreateTransactionDetails() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.post(APIV1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getUserDto()))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }


    @Test
    public void whenTransactionIdNotFoundShouldGetError404WhenRequestMadeToGetTransactionDetails() throws Exception
    {
        MvcResult mvcResult =
                mvc.perform(get(APIV1+"/userId1")
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isNotFound())
                        .andReturn();

        int expectedErrorResponse = 404;
        int actualResponse = mvcResult.getResponse().getStatus();
        System.out.println("actualResponseBody------->"+actualResponse);
        assertThat(actualResponse)
                .isEqualTo(expectedErrorResponse);
    }

    @Test
    public void whenTransactionIdNotFoundShouldGetError404WhenRequestMadeToDeleteTransactionDetails() throws Exception
    {
        MvcResult mvcResult =
                mvc.perform(delete(APIV1+"/userId1")
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isNotFound())
                        .andReturn();

        int expectedErrorResponse = 404;
        int actualResponse = mvcResult.getResponse().getStatus();
        System.out.println("actualResponseBody------->"+actualResponse);
        assertThat(actualResponse)
                .isEqualTo(expectedErrorResponse);
    }
}
