package com.userservice.controller.login;

import lombok.Builder;

@Builder
public class JWTRequest {

    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public JWTRequest() {
    }

    public JWTRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
