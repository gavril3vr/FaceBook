package com.vsc.facebook.fbcopy.controller;

import com.vsc.facebook.fbcopy.dto.ProfilePageDTO;
import com.vsc.facebook.fbcopy.service.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfilePageControlelr extends BaseController {
    private final UserService userService;

    @Autowired
    public ProfilePageControlelr(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/profile")
    public ModelAndView getUserDetails(@ModelAttribute("user")ProfilePageDTO profilePageDTO){return send("profile");}
}
