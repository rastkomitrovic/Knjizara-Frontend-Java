package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.dto.OrderDTO;
import com.fon.knjizarafrontend.request.OrderRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    ResponseEntity<OrderDTO[]> findOrdersByUsername(String username);

    ResponseEntity<Object> saveOrder(OrderRequest orderRequest);

    ResponseEntity<OrderDTO> findOrderByOrderId(String orderId);

}
