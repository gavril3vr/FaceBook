package com.vsc.facebook.fbcopy.dto;

import javax.validation.constraints.NotBlank;

public class RegisterDTO {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String passwordRepeat;

    @NotBlank
    private int age;

    public RegisterDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }
}
