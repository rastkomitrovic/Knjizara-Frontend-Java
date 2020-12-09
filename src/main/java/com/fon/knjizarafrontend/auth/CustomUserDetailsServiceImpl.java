package com.fon.knjizarafrontend.auth;

import com.fon.knjizarafrontend.dto.UserDTO;
import com.fon.knjizarafrontend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ResponseEntity<UserDTO> response=userService.findUserByUsername(s);
        if(response.getStatusCode()== HttpStatus.OK)
            return response.getBody().toCustomUserDetails();
        throw new UsernameNotFoundException("Ne postoji korisnik sa unetim kredencijalima");
    }
}
