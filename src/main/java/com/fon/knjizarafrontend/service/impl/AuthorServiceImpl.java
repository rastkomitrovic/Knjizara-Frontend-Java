package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.dto.AuthorDTO;
import com.fon.knjizarafrontend.service.AuthorService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Resource
    private RestTemplate restTemplate;

    private final String api = ApiConstants.authorsApi;

    @Override
    public ResponseEntity<AuthorDTO[]> findAllAuthorsNoPaging() {
        return restTemplate.getForEntity(api, AuthorDTO[].class);
    }

    @Override
    public ResponseEntity<RestPageImpl<AuthorDTO>> findAllAuthors(int page, int size, String sort) {
        ParameterizedTypeReference<RestPageImpl<AuthorDTO>> responseType = new ParameterizedTypeReference<RestPageImpl<AuthorDTO>>() {
        };
        return restTemplate.exchange(api + "/" + page + "/" + size + "/" + sort, HttpMethod.GET, null, responseType);
    }

    @Override
    public ResponseEntity<RestPageImpl<AuthorDTO>> findAllAuthorsSearch(int page, int size, String sort, String param) {
        ParameterizedTypeReference<RestPageImpl<AuthorDTO>> responseType = new ParameterizedTypeReference<RestPageImpl<AuthorDTO>>() {
        };
        return restTemplate.exchange(api + "/" + page + "/" + size + "/" + sort + "/" + param, HttpMethod.GET, null, responseType);
    }

    @Override
    public ResponseEntity<Object> saveAuthor(AuthorDTO authorDTO) {
        return restTemplate.postForEntity(api, authorDTO, Object.class);
    }

    @Override
    public ResponseEntity<Object> updateAuthor(AuthorDTO authorDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AuthorDTO> httpEntity = new HttpEntity<>(authorDTO, headers);
        return restTemplate.exchange(api, HttpMethod.PUT, httpEntity, Object.class);
    }

    @Override
    public ResponseEntity<Object> deleteAuthor(long authorId) {
        return restTemplate.exchange(api + "/" + authorId, HttpMethod.DELETE, null, Object.class);
    }

    @Override
    public ResponseEntity<AuthorDTO> findAuthor(Long authorId) {
        return restTemplate.getForEntity(api+"/"+authorId,AuthorDTO.class);
    }
}
