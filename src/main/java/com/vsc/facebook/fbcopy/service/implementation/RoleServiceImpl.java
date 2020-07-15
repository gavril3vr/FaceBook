package com.vsc.facebook.fbcopy.service.implementation;

import com.vsc.facebook.fbcopy.entity.Role;
import com.vsc.facebook.fbcopy.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImpl {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public Role getUserRole() {
        Role userRole = roleRepository.findFirstByAuthority("ROLE_USER")
                .orElseThrow(() -> new IllegalStateException("User role not found"));

        return userRole;
    }
}
