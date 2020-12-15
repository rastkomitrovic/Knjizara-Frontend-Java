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

    @Override
    public ResponseEntity<PublisherDTO> findPublisherByPublisherId(Long publisherId) {
        return restTemplate.getForEntity(api + "/" + publisherId, PublisherDTO.class);
    }

    @Override
    public ResponseEntity<Object> savePublisher(PublisherDTO publisher) {
        return restTemplate.postForEntity(api, publisher, Object.class);
    }

    @Override
    public ResponseEntity<Object> updatePublisher(PublisherDTO publisher) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PublisherDTO> entity = new HttpEntity<>(publisher, headers);
        return restTemplate.exchange(api, HttpMethod.PUT, entity, Object.class);
    }

    @Override
    public ResponseEntity<Object> deletePublisher(Long publisherId) {
        return restTemplate.exchange(api + "/" + publisherId, HttpMethod.DELETE, null, Object.class);
    }
}
