package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.dto.OrderDTO;
import org.springframework.http.ResponseEntity;

public interface BasketService {
    ResponseEntity<OrderDTO> findBasketByUserUsername(String username);

    ResponseEntity<Object> saveBasket(OrderDTO orderDTO);

    ResponseEntity<Object> updateBasket(OrderDTO orderDTO);

    ResponseEntity<Object> deleteBasket(long basketId);
}
