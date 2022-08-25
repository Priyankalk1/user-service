package model;

import lombok.*;


import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@Data
@Entity
@AllArgsConstructor


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
    private Date dateOfBirth;
    private Date createdAt;
    private Date updatedAt;
   private String role;

    private String password;

//    public static int getId() {
  //          return 0;
   // }
}
