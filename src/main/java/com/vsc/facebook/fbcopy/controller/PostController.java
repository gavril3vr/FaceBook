package com.vsc.facebook.fbcopy.controller;

import com.vsc.facebook.fbcopy.service.implementation.PostServiceImpl;
import com.vsc.facebook.fbcopy.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PostController {
    private final PostServiceImpl postService;
    private final UserServiceImpl userService;

    @Autowired
    public PostController(PostServiceImpl postService, UserServiceImpl userService) {
        this.postService = postService;
        this.userService = userService;
    }

}
