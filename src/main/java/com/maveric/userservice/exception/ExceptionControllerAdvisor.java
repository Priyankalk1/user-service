package com.maveric.userservice.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.maveric.userservice.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;
import static com.maveric.userservice.constants.Constants.*;

@RestControllerAdvice
public class ExceptionControllerAdvisor {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final ErrorDto handleUserNotFoundException(UserNotFoundException exception) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(USER_NOT_FOUND_CODE);
        errorDto.setMessage(exception.getMessage());
        return errorDto;
    }
    @ExceptionHandler(InvalidException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final ErrorDto invalidException(InvalidException exception) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(BAD_REQUEST_CODE);
        errorDto.setMessage(exception.getMessage());
        return errorDto;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        ErrorDto errorDto = new ErrorDto();
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        errorDto.setCode(BAD_REQUEST_CODE);
        errorDto.setMessage(BAD_REQUEST_MESSAGE);
        errorDto.setErrors(errors);
        return errorDto;
    }


    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ErrorDto handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException ex) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(METHOD_NOT_ALLOWED_CODE);
        errorDto.setMessage(METHOD_NOT_ALLOWED_MESSAGE);
        return errorDto;
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleHttpMessageNotReadableException(
            HttpMessageNotReadableException ex) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(BAD_REQUEST_CODE);
        System.out.println(ex.getMessage());
        if(ex.getMessage().contains("com.maveric.userservice.enumeration.Gender"))
            errorDto.setMessage(INVALID_INPUT_TYPE);
        else
            errorDto.setMessage(HttpMessageNotReadableException_MESSAGE);
        return errorDto;
    }

}
