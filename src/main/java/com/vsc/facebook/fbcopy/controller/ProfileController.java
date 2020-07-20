package com.vsc.facebook.fbcopy.controller;

import com.dropbox.core.DbxException;
import com.vsc.facebook.fbcopy.dto.ImageUploadDTO;
import com.vsc.facebook.fbcopy.service.implementation.ImageUploadService;
import com.vsc.facebook.fbcopy.service.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.security.Principal;

@Controller
public class ProfileController extends BaseController {
    private final UserService userService;
    private final ImageUploadService imageUploadService;

    @Autowired
    public ProfileController(ImageUploadService imageUploadService, UserService userService) {
        this.imageUploadService = imageUploadService;
        this.userService=userService;
    }

    @GetMapping("/profile")
    public ModelAndView setProfilePage() {
        return send("profile");
    }

    @PostMapping("/profile")
    public ModelAndView setProfilePicture(@ModelAttribute ImageUploadDTO imageUploadDTO) throws IOException {
        imageUploadService.uploadImage(imageUploadDTO.getImage());
        return redirect("profile");
    }

    @PostMapping("/profile/image")
    public ModelAndView imageUpload(@ModelAttribute ImageUploadDTO imageUploadDTO, Principal principal) throws IOException {


        try {
            String link = imageUploadService.uploadToDropbox(imageUploadDTO);
            userService.setProfileImage(principal.getName(), link);
        } catch (DbxException e) {
            e.printStackTrace();
        }
        return redirect("/");
    }
}
