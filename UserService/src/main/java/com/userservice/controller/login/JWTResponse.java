package com.userservice.controller.login;

public class JWTResponse {

    private String jwttoken;

    private String username;

    public String getJwttoken() {
        return jwttoken;
    }

    public void setJwttoken(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public JWTResponse() {
    }

    public JWTResponse(String jwttoken, String username) {
        this.jwttoken = jwttoken;
        this.username = username;
    }

    @Override
    public String toString() {
        return "JWTResponse{" +
                "jwttoken='" + jwttoken + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

}
