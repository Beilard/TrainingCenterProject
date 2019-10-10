package com.study.epamproject.domain.user;

public class UserCredential {
    private final String email;
    private final String password;

    public UserCredential(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
