package com.communicators.welltalk.dto;

public class ForgotPasswordDTO {
    private String email;
    private String password;

    public ForgotPasswordDTO() {
    }

    public ForgotPasswordDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

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
}
