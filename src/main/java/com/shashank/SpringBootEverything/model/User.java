package com.shashank.SpringBootEverything.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "User")
public class User {
    @Id
    private String id;
    private String userName;
    private String password;

    private String email;

    private String mobile;

    public User(String userName, String password, String email, String mobile) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
    }
}
