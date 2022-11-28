package com.maveric.userservice.exception;

import com.maveric.userservice.dto.ErrorDto;
import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ExceptionControllerAdvisorTest {
    private ExceptionControllerAdvisor controllerAdvisor = new ExceptionControllerAdvisor();
    @Test
    void handleUserNotFoundException() {
        UserNotFoundException exception = new UserNotFoundException("User Not found");
        ErrorDto error = controllerAdvisor.handleUserNotFoundException(exception);
        assertEquals("404",error.getCode());
    }

    @Test
    void handleUserAlreadyExistException() {
        UserAlreadyExistException exception = new UserAlreadyExistException("User Already Exist");
        ErrorDto error = controllerAdvisor.handleUserAlreadyExistException(exception);
        assertEquals("400",error.getCode());
      }

    @Test
    void invalidException() {
        InvalidException exception = new InvalidException("User Not found");
        ErrorDto error = controllerAdvisor.invalidException(exception);
        assertEquals("404",error.getCode());
      }


    @Test
    void handleHttpRequestMethodNotSupportedException() {
        MethodParameter methodParameter = mock(MethodParameter.class);
        BindingResult bindingResult = mock(BindingResult.class);
        HttpRequestMethodNotSupportedException exception = new HttpRequestMethodNotSupportedException("error");;
        ErrorDto error = controllerAdvisor.handleHttpRequestMethodNotSupportedException(exception);
        assertEquals("405",error.getCode());
      }
    @Test
    void handleHttpMessageNotReadableException()
    {
        HttpMessageNotReadableException exception = new HttpMessageNotReadableException("Exception");
        ErrorDto error = controllerAdvisor.handleHttpMessageNotReadableException(exception);
        assertEquals("400",error.getCode());
    }

    @Test
    void handleOtherHttpException()
    {
        Exception exception = new Exception();
        ErrorDto error = controllerAdvisor.handleOtherHttpException(exception);
        assertEquals("500",error.getCode());
    }
}