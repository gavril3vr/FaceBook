package com.vsc.facebook.fbcopy.service.implementation;

import com.vsc.facebook.fbcopy.entity.Image;
import com.vsc.facebook.fbcopy.entity.User;
import com.vsc.facebook.fbcopy.repository.ImageRepository;
import com.vsc.facebook.fbcopy.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService{

    private final ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image createImage(User user) {
        Image image=new Image();
        return imageRepository.save(image);
    }
}
