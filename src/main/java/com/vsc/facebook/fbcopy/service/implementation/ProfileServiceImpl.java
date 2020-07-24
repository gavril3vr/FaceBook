package com.vsc.facebook.fbcopy.service.implementation;

import com.vsc.facebook.fbcopy.entity.Image;
import com.vsc.facebook.fbcopy.entity.Profile;
import com.vsc.facebook.fbcopy.entity.User;
import com.vsc.facebook.fbcopy.repository.ProfileRepository;
import com.vsc.facebook.fbcopy.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile createProfile(User user) {
        Profile profile=new Profile();
      return profileRepository.save(profile);
    }

}
