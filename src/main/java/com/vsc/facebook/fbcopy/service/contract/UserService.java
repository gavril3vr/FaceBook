package com.vsc.facebook.fbcopy.service.contract;

import com.vsc.facebook.fbcopy.dto.RegisterDTO;
import com.vsc.facebook.fbcopy.entity.User;

public interface UserService {

    User register(RegisterDTO registerDTO);


    void setProfileImage(String name, String link);

}
