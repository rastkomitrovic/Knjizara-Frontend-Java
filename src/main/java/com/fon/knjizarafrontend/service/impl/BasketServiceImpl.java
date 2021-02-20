package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.dto.OrderDTO;
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
    public ResponseEntity<OrderDTO> findBasketByUserUsername(String username) {
        return restTemplate.getForEntity(api + "/" + username, OrderDTO.class);
    }

    @Override
    public ResponseEntity<Object> saveBasket(OrderDTO orderDTO) {
        return restTemplate.postForEntity(api, orderDTO, Object.class);
    }

    @Override
    public ResponseEntity<Object> updateBasket(OrderDTO orderDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OrderDTO> entity = new HttpEntity<>(orderDTO, headers);
        return restTemplate.exchange(api, HttpMethod.PUT, entity, Object.class);
    }

    @Override
    public ResponseEntity<Object> deleteBasket(long basketId) {
        return restTemplate.exchange(api + "/" + basketId, HttpMethod.DELETE, null, Object.class);
    }
}
