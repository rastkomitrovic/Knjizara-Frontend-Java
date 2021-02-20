package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.dto.OrderDTO;
import com.fon.knjizarafrontend.request.OrderRequest;
import com.fon.knjizarafrontend.service.OrderService;
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
    public ResponseEntity<OrderDTO[]> findOrdersByUsername(String username) {
        return restTemplate.getForEntity(api + "/" + username, OrderDTO[].class);
    }

    @Override
    public ResponseEntity<Object> saveOrder(OrderRequest orderRequest) {
        return restTemplate.postForEntity(api, orderRequest, Object.class);
    }

    @Override
    public ResponseEntity<OrderDTO> findOrderByOrderId(String orderId) {
        return restTemplate.getForEntity(api+"/id/"+orderId,OrderDTO.class);
    }


}
