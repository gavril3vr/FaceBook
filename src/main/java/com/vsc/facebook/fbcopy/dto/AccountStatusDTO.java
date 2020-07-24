package com.vsc.facebook.fbcopy.dto;


import com.vsc.facebook.fbcopy.entity.User;
import com.vsc.facebook.fbcopy.repository.UserRepository;
import org.springframework.context.annotation.Bean;

public class AccountStatusDTO {

    private String passwordToBeChecked;
    private String email;

    public AccountStatusDTO() {
    }

    public String getPasswordToBeChecked() {
        return passwordToBeChecked;
    }

    public String getEmail() {
        return email;
    }


}
