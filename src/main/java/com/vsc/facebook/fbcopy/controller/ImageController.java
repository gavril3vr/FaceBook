package com.vsc.facebook.fbcopy.controller;

import com.dropbox.core.DbxException;
import com.vsc.facebook.fbcopy.dto.ImageUploadDTO;
import com.vsc.facebook.fbcopy.service.implementation.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class ImageController extends BaseController {
    private final ImageUploadService imageUploadService;
    private final UserService userService;

    @Autowired
    public ImageController(ImageUploadService imageUploadService, UserService userService) {
        this.imageUploadService = imageUploadService;
        this.userService = userService;
    }

//    @PreAuthorize("isAuthenticated()")
//    @GetMapping("/profile")
//    public ModelAndView profile(@AuthenticationPrincipal User user) {
//        String url = user.getProfile().getProfileImage().getUrl();
//        return send("profile", "profilePicture", url);
//    }

    @GetMapping("/upload")
    public ModelAndView imageUpload() {
        return send("upload");
    }

    @PostMapping("/upload")
    public ModelAndView imageUpload(@ModelAttribute ImageUploadDTO imageUploadDTO) throws IOException, DbxException {
        imageUploadService.uploadImage(imageUploadDTO.getImage());
        imageUploadService.uploadToDropbox(imageUploadDTO);
        return redirect("/");
    }
}
