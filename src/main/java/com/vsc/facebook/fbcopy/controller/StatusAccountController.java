package com.vsc.facebook.fbcopy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StatusAccountController {

    @GetMapping("/deactivation")
    public ModelAndView accountDeactivation() {
        return new ModelAndView("deactivation.html");
    }

    @PostMapping("/deactivation")
    public ModelAndView deactivation() {
        return new ModelAndView("deactivation.html");
    }

    @GetMapping("/activation")
    public ModelAndView accountActivation() {
        return new ModelAndView("activation.html");
    }

    @PostMapping("/activation")
    public ModelAndView activation() {
        return new ModelAndView("activation.html");
    }
}
