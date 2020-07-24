package com.vsc.facebook.fbcopy.service.contract;

import com.vsc.facebook.fbcopy.dto.RegisterDTO;
import com.vsc.facebook.fbcopy.entity.User;

import javax.validation.constraints.Email;

public interface UserService {

    User register(RegisterDTO registerDTO, User user);

    void setProfileImage(String email,String link);

}
