package com.vsc.facebook.fbcopy.service.implementation;

import com.vsc.facebook.fbcopy.dto.ProfilePageDTO;
import com.vsc.facebook.fbcopy.dto.RegisterDTO;
import com.vsc.facebook.fbcopy.entity.Role;
import com.vsc.facebook.fbcopy.entity.User;
import com.vsc.facebook.fbcopy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{

    private final UserRepository userRepository;
    private final RoleServiceImpl roleService;
    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleServiceImpl roleService, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;

    }
    @Override
    public com.vsc.facebook.fbcopy.entity.User getUserDetails(ProfilePageDTO profilePageDTO){
        com.vsc.facebook.fbcopy.entity.User user = new com.vsc.facebook.fbcopy.entity.User();
        user.setFirstName(profilePageDTO.getFirstName());
        user.setLastName(profilePageDTO.getLastName());
        user.setAge(Integer.parseInt(profilePageDTO.getAge()));
        user.setEmail(profilePageDTO.getEmail());
        return user;
    }


    @Override
    public com.vsc.facebook.fbcopy.entity.User register(RegisterDTO registerDTO) {
        if (!registerDTO.getPassword().equals(registerDTO.getPasswordRepeat())) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        User user = new User();
        user.setFirstName(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setEmail(registerDTO.getEmail());
        user.setAge(registerDTO.getAge());
        userRepository.save(user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findFirstByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found; with username: " + username));

        return user;
    }
}

