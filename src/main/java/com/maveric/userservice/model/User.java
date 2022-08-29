package com.maveric.userservice.model;
import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name="UserDetails")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String address;
    private Date dateOfBirth;
    private Date createdAt;
    private Date updatedAt;
    private String role;
    private String password;

}
