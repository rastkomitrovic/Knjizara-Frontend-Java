package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<UserDTO> findUserByUsername(String username);

    ResponseEntity<Object> deleteUserByUsername(String username);

    ResponseEntity<Object> saveUser(UserDTO userDTO);

    ResponseEntity<Object> updateUser(UserDTO userDTO);
}
