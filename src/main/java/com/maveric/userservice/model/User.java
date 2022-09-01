package com.maveric.userservice.model;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@Entity
@AllArgsConstructor
@Data
@Table(name="UserDetails")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String address;
    private String dateOfBirth;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    private String role;
    private String password;

}
