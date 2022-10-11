package com.maveric.userservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ErrorDto {
    String code;
    String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Map<String, String> errors;

}
