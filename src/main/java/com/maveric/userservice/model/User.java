package com.maveric.userservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maveric.userservice.enumeration.Gender;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(name = "user_details")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private LocalDateTime dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String role;
    private String Password;

}
