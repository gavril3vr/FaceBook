package com.vsc.facebook.fbcopy.service.implementation;

import com.vsc.facebook.fbcopy.dto.RegisterDTO;
import com.vsc.facebook.fbcopy.entity.Image;
import com.vsc.facebook.fbcopy.entity.Profile;
import com.vsc.facebook.fbcopy.entity.Role;
import com.vsc.facebook.fbcopy.entity.User;
import com.vsc.facebook.fbcopy.repository.UserRepository;
import com.vsc.facebook.fbcopy.service.contract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(RegisterDTO registerDTO) {
        if (!registerDTO.getPassword().equals(registerDTO.getPasswordRepeat())) {
            throw new IllegalArgumentException("Passwords do not match");
        }
        if (userRepository.existsByEmail(registerDTO.getEmail())) {
            throw new IllegalArgumentException("user already exists");
        }
        if (registerDTO.getAge() < 14) {
            throw new IllegalArgumentException("You are too young!");
        }

        User user = new User();
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setEmail(registerDTO.getEmail());
        user.setAge(registerDTO.getAge());
        user.setFirstName(registerDTO.getFirstName());
        user.setLastName(registerDTO.getLastName());
        user.setActive(true);
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getUserRole());
        user.setAuthorities(roles);
        userRepository.save(user);

        user.setProfile(new Profile());
        user.getProfile().setProfileImage(new Image());
        user.getProfile().getProfileImage().setUrl("https://www.dropbox.com/h?preview=%D0%B8%D0%B7%D1%82%D0%B5%D0%B3%D0%BB%D0%B5%D0%BD+%D1%84%D0%B0%D0%B9%D0%BB.jpg");
        userRepository.save(user);


        return user;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findFirstByEmail(s).orElseThrow(() -> new UsernameNotFoundException("User not found "));
    }

    public User findByEmail(String username) throws UsernameNotFoundException {
        User user = userRepository.findFirstByEmail(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found; with username: " + username));

        return user;
    }

    public void setProfileImage(String email, String link) {

        User user = findByEmail(email);
        Image image = new Image();
        image.setUrl(link);
        user.getProfile().setProfileImage(image);
        userRepository.save(user);
    }

}

