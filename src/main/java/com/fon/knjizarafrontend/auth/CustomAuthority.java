package com.fon.knjizarafrontend.auth;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class CustomAuthority implements GrantedAuthority {

    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}
