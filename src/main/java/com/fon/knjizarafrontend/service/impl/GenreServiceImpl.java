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

    @Override
    public ResponseEntity<GenreDTO> findGenreByGenreId(long genreId) {
        return restTemplate.getForEntity(api + "/" + genreId, GenreDTO.class);
    }

    @Override
    public ResponseEntity<RestPageImpl<GenreDTO>> findAllGenresPaging(int page, int size, String sort) {
        ParameterizedTypeReference<RestPageImpl<GenreDTO>> responseType = new ParameterizedTypeReference<RestPageImpl<GenreDTO>>() {
        };
        return restTemplate.exchange(api + "/" + page + "/" + size + "/" + sort, HttpMethod.GET, null, responseType);
    }

    @Override
    public ResponseEntity<RestPageImpl<GenreDTO>> findAllGenresPagingSearch(int page, int size, String sort, String search) {
        ParameterizedTypeReference<RestPageImpl<GenreDTO>> responseType = new ParameterizedTypeReference<RestPageImpl<GenreDTO>>() {
        };
        return restTemplate.exchange(api + "/" + page + "/" + size + "/" + sort + "/" + search, HttpMethod.GET, null, responseType);
    }

    @Override
    public ResponseEntity<Object> saveGenre(GenreDTO genreDTO) {
        return restTemplate.postForEntity(api, genreDTO, Object.class);
    }

    @Override
    public ResponseEntity<Object> updateGenre(GenreDTO genreDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<GenreDTO> entity = new HttpEntity<>(genreDTO, headers);
        return restTemplate.exchange(api, HttpMethod.PUT, entity, Object.class);
    }

    @Override
    public ResponseEntity<Object> deleteGenre(long genreId) {
        return restTemplate.exchange(api + "/" + genreId, HttpMethod.DELETE, null, Object.class);
    }
}
