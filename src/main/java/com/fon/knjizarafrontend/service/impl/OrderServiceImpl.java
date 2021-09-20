package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.dto.BookDTO;
import com.fon.knjizarafrontend.dto.OrderDTO;
import com.fon.knjizarafrontend.request.OrderRequest;
import com.fon.knjizarafrontend.service.OrderService;
import org.hibernate.criterion.Order;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private RestTemplate restTemplate;

    private final String api = ApiConstants.basketsApi;

    @Override
    public ResponseEntity<RestPageImpl<OrderDTO>> findOrdersByUsername(String username, int page, int size, String sort) {
        ParameterizedTypeReference<RestPageImpl<OrderDTO>> responseType = new ParameterizedTypeReference<RestPageImpl<OrderDTO>>() {
        };
        return restTemplate.exchange(api + "/" + username + "/" + page + "/" + size + "/" + sort, HttpMethod.GET, null, responseType);
    }

    @Override
    public ResponseEntity<Object> saveOrder(OrderRequest orderRequest) {
        return restTemplate.postForEntity(api, orderRequest, Object.class);
    }

    @Override
    public ResponseEntity<RestPageImpl<OrderDTO>> findOrdersPaging(int page, int size, String sort) {
        ParameterizedTypeReference<RestPageImpl<OrderDTO>> responseType = new ParameterizedTypeReference<RestPageImpl<OrderDTO>>() {
        };

        return restTemplate.exchange(api+"/"+page+"/"+size+"/"+sort, HttpMethod.GET,null,responseType);
    }

}
