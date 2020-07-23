package com.vsc.facebook.fbcopy.controller;


import com.vsc.facebook.fbcopy.dto.RegisterDTO;
import com.vsc.facebook.fbcopy.repository.UserRepository;
import com.vsc.facebook.fbcopy.service.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;


@Controller
public class UserController extends BaseController {
    private final UserService userService;

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

        userService.register(registerDTO);
        return redirect("login");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return send("login");
    }

    @PreAuthorize("!isAuthenticated()")
    @GetMapping("/profile")
    public ModelAndView profile(Principal principal) {
        return send("profile");
    }

    @GetMapping("/my-page")
    public ModelAndView myPage() {
        return send("profile");
    }
}