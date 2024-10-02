package com.myProject.springboot.myFirstWeb.Authentication;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {
        // in real world scenario, this method will be used to authenticate user
        // by checking the username and password against the database
        return  username.equalsIgnoreCase("ankit") && password.equals("dummy");
    }
}
