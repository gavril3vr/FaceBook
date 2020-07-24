package com.vsc.facebook.fbcopy.controller;


import com.vsc.facebook.fbcopy.dto.RegisterDTO;
import com.vsc.facebook.fbcopy.entity.User;
import com.vsc.facebook.fbcopy.service.contract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;


@Controller
public class UserController extends BaseController {
    private final UserService userService;
    private User user;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public ModelAndView register(@ModelAttribute("user") RegisterDTO registerDTO) {
        return send("register");
    }

    @PostMapping("/register")
    public ModelAndView register(@Validated @ModelAttribute("user") RegisterDTO registerDTO, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("user", registerDTO);
            return redirect("register");
        }

        userService.register(registerDTO, user);
        return redirect("login");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return send("login");
    }

    @GetMapping("/profile")
    public ModelAndView profile(Principal principal) {
        return send("profile", "username", principal.getName());
    }

    @GetMapping("/my-page")
    public ModelAndView myPage() {
        return send("profile");
    }
}