package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.dto.BasketDTO;
import org.springframework.http.ResponseEntity;

public interface BasketService {
    ResponseEntity<BasketDTO> findBasketByBasketId(long basketId);

    ResponseEntity<Object> saveBasket(BasketDTO basketDTO);

    ResponseEntity<Object> updateBasket(BasketDTO basketDTO);

    ResponseEntity<Object> deleteBasket(long basketId);
}
