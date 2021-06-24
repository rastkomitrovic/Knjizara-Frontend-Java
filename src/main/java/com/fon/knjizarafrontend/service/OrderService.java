package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.dto.BookDTO;
import com.fon.knjizarafrontend.dto.OrderDTO;
import com.fon.knjizarafrontend.request.OrderRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    ResponseEntity<RestPageImpl<OrderDTO>> findOrdersByUsername(String username, int page, int size, String sort);

    ResponseEntity<Object> saveOrder(OrderRequest orderRequest);

}
