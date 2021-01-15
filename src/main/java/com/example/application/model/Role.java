package com.example.application.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, SECURE;

    @Override
    public String getAuthority() {
        return name();
    }
}
