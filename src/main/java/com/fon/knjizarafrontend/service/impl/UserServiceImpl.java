package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.dto.UserDTO;
import com.fon.knjizarafrontend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;

    private final String api = ApiConstants.usersApi;

    @Override
    public ResponseEntity<UserDTO> findUserByUsername(String username) {
        return restTemplate.getForEntity(api + "/" + username, UserDTO.class);
    }

    @Override
    public ResponseEntity<Object> deleteUserByUsername(String username) {
        return restTemplate.exchange(api + "/" + username, HttpMethod.DELETE, null, Object.class);
    }

    @Override
    public ResponseEntity<Object> saveUser(UserDTO userDTO) {
        return restTemplate.postForEntity(api, userDTO, Object.class);
    }

    @Override
    public ResponseEntity<Object> updateUser(UserDTO userDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserDTO> entity = new HttpEntity<>(userDTO, headers);
        return restTemplate.exchange(api, HttpMethod.PUT, entity, Object.class);
    }
}
