package com.maveric.userservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.maveric.userservice.enumeration.Gender;
import com.maveric.userservice.utility.DateDeSerializer;
import com.maveric.userservice.validation.PhoneNumber;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor

public class EmailDto {

    private String _id;
    @Size(min = 2 , message="First Name atleast 2 charaters")
    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @Size(min = 1 , message="Last Name atleast 1 charaters")
    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @Size(min = 1 , message="Middle Name atleast 1 charaters")
    @NotBlank(message = "Middle Name is mandatory")
    private String middleName;

    @PhoneNumber(message = "This phone number is not valid")
    @NotBlank(message = "Phone Number is mandatory")
    private String phoneNumber;

    @Email(message = "Email Should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @JsonDeserialize(using = DateDeSerializer.class)
    @Past(message = "Date Should be past")
    @NotNull(message = "Date of Birth is mandatory")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Gender is mandatory 'MALE' or 'FEMALE'")
    private Gender gender;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String role;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotBlank(message = "Password is mandatory")
    private String Password;
}
