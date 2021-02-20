package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.dto.OrderItemDTO;
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
    public ResponseEntity<RestPageImpl<OrderItemDTO>> findEntriesByBasketId(long basketId, int page, int size, String sort, boolean active) {
        ParameterizedTypeReference<RestPageImpl<OrderItemDTO>> responseType = new ParameterizedTypeReference<RestPageImpl<OrderItemDTO>>() {
        };
        return restTemplate.exchange(api + "/" + basketId + "/" + page + "/" + size + "/" + sort + "/" + active, HttpMethod.GET, null, responseType);
    }

    @Override
    public ResponseEntity<Object> saveBasketEntry(OrderItemDTO orderItemDTO) {
        return restTemplate.postForEntity(api, orderItemDTO, Object.class);
    }

    @Override
    public ResponseEntity<Object> updateBasketEntry(OrderItemDTO orderItemDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OrderItemDTO> entity = new HttpEntity<>(orderItemDTO, headers);
        return restTemplate.exchange(api, HttpMethod.PUT, entity, Object.class);
    }

    @Override
    public ResponseEntity<Object> deleteBasketEntry(long entryId) {
        return restTemplate.exchange(api + "/" + entryId, HttpMethod.DELETE, null, Object.class);
    }
}
