package com.example.bytefitjava.bytefit.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
public class User {

    @Id
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private Integer mobileNum;
    private String password;

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }
}
