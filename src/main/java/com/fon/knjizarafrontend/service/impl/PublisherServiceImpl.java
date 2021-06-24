package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.dto.PublisherDTO;
import com.fon.knjizarafrontend.service.PublisherService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Resource
    private RestTemplate restTemplate;

    public final String api = ApiConstants.publishersApi;

    @Override
    public ResponseEntity<PublisherDTO[]> getAllPublishers() {
        return restTemplate.getForEntity(api, PublisherDTO[].class);
    }

}
