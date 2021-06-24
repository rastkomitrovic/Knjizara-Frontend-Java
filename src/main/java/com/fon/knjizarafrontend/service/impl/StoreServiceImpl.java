package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.dto.StoreDTO;
import com.fon.knjizarafrontend.service.StoreService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class StoreServiceImpl implements StoreService {

    @Resource
    private RestTemplate restTemplate;

    private final String api = ApiConstants.storesApi;


    @Override
    public ResponseEntity<StoreDTO[]> findAllStores() {
        return restTemplate.getForEntity(api, StoreDTO[].class);
    }

}
