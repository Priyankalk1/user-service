package com.maveric.userservice.dto;
import lombok.Data;

@Data
public class UserDto {

    private int id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String address;
    private String dateOfBirth;
    private String createdAt;
    private String updatedAt;
    private String role;
    private String password;

}
