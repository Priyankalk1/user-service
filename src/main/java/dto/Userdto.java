package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@Data
@AllArgsConstructor

public class Userdto {

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

}
