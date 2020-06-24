package com.vsc.facebook.fbcopy.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public String getAuthority() {
        return null;
    }
}
