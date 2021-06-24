package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.dto.GenreDTO;
import com.fon.knjizarafrontend.service.GenreService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class GenreServiceImpl implements GenreService {

    @Resource
    private RestTemplate restTemplate;

    private final String api = ApiConstants.genresApi;

    @Override
    public ResponseEntity<GenreDTO[]> getAllGenresNoPaging() {
        return restTemplate.getForEntity(api, GenreDTO[].class);
    }

}
