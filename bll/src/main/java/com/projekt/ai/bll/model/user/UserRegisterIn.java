package com.projekt.ai.bll.model.user;

import lombok.Data;

/**
 * Created by Lenovo on 2017-12-03.
 */

@Data
public class UserRegisterIn {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String city;
    private String street;
    private String houseNumber;
    private String postNumber;
}
