package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.dto.BasketDTO;
import com.fon.knjizarafrontend.service.BasketService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class BasketServiceImpl implements BasketService {

    @Resource
    private RestTemplate restTemplate;

    private final String api = ApiConstants.basketsApi;

    @Override
    public ResponseEntity<BasketDTO> findBasketByUserUsername(String username) {
        return restTemplate.getForEntity(api + "/" + username, BasketDTO.class);
    }

    @Override
    public ResponseEntity<Object> saveBasket(BasketDTO basketDTO) {
        return restTemplate.postForEntity(api, basketDTO, Object.class);
    }

    @Override
    public ResponseEntity<Object> updateBasket(BasketDTO basketDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<BasketDTO> entity = new HttpEntity<>(basketDTO, headers);
        return restTemplate.exchange(api, HttpMethod.PUT, entity, Object.class);
    }

    @Override
    public ResponseEntity<Object> deleteBasket(long basketId) {
        return restTemplate.exchange(api + "/" + basketId, HttpMethod.DELETE, null, Object.class);
    }
}
