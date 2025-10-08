package com.shashank.SpringBootEverything.model;

import com.shashank.SpringBootEverything.customannotation.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    String userName;
    String password;
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "please enter mobile number")
    private String mobile;

}
