package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.dto.StoreDTO;
import com.fon.knjizarafrontend.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private RestTemplate restTemplate;

    private final String api = ApiConstants.storesApi;


    @Override
    public ResponseEntity<StoreDTO[]> findAllStores() {
        return restTemplate.getForEntity(api, StoreDTO[].class);
    }

    @Override
    public ResponseEntity<RestPageImpl<StoreDTO>> findAllStoresPaging(int page, int size, String sort) {
        ParameterizedTypeReference<RestPageImpl<StoreDTO>> responseType = new ParameterizedTypeReference<RestPageImpl<StoreDTO>>() {
        };
        return restTemplate.exchange(api + "/" + page + "/" + size + "/" + sort, HttpMethod.GET, null, responseType);
    }

    @Override
    public ResponseEntity<RestPageImpl<StoreDTO>> findAllStoresPagingSearch(int page, int size, String sort, String param) {
        ParameterizedTypeReference<RestPageImpl<StoreDTO>> responseType = new ParameterizedTypeReference<RestPageImpl<StoreDTO>>() {
        };
        return restTemplate.exchange(api + "/" + page + "/" + size + "/" + sort + "/" + param, HttpMethod.GET, null, responseType);
    }

    @Override
    public ResponseEntity<StoreDTO> findStoreByStoreId(long storeId) {
        return restTemplate.getForEntity(api + "/" + storeId, StoreDTO.class);
    }

    @Override
    public ResponseEntity<Object> saveStore(StoreDTO storeDTO) {
        return restTemplate.postForEntity(api, storeDTO, Object.class);
    }

    @Override
    public ResponseEntity<Object> updateStore(StoreDTO storeDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<StoreDTO> entity = new HttpEntity<>(storeDTO, headers);
        return restTemplate.exchange(api, HttpMethod.PUT, entity, Object.class);
    }

    @Override
    public ResponseEntity<Object> deleteStore(long storeId) {
        return restTemplate.exchange(api + "/" + storeId, HttpMethod.DELETE, null, Object.class);
    }
}
