package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.dto.BasketEntryDTO;
import com.fon.knjizarafrontend.service.BasketEntryService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class BasketEntryServiceImpl implements BasketEntryService {

    @Resource
    private RestTemplate restTemplate;

    private final String api = ApiConstants.basketEntriesApi;

    @Override
    public ResponseEntity<RestPageImpl<BasketEntryDTO>> findEntriesByBasketId(long basketId, int page, int size, String sort, boolean active) {
        ParameterizedTypeReference<RestPageImpl<BasketEntryDTO>> responseType = new ParameterizedTypeReference<RestPageImpl<BasketEntryDTO>>() {
        };
        return restTemplate.exchange(api + "/" + basketId + "/" + page + "/" + size + "/" + sort + "/" + active, HttpMethod.GET, null, responseType);
    }

    @Override
    public ResponseEntity<Object> saveBasketEntry(BasketEntryDTO basketEntryDTO) {
        return restTemplate.postForEntity(api, basketEntryDTO, Object.class);
    }

    @Override
    public ResponseEntity<Object> updateBasketEntry(BasketEntryDTO basketEntryDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<BasketEntryDTO> entity = new HttpEntity<>(basketEntryDTO, headers);
        return restTemplate.exchange(api, HttpMethod.PUT, entity, Object.class);
    }

    @Override
    public ResponseEntity<Object> deleteBasketEntry(long entryId) {
        return restTemplate.exchange(api + "/" + entryId, HttpMethod.DELETE, null, Object.class);
    }
}
