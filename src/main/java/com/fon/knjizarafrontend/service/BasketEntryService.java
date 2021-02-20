package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.dto.OrderItemDTO;
import org.springframework.http.ResponseEntity;

public interface BasketEntryService {
    ResponseEntity<RestPageImpl<OrderItemDTO>> findEntriesByBasketId(long basketId, int page, int size, String sort, boolean active);

    ResponseEntity<Object> saveBasketEntry(OrderItemDTO orderItemDTO);

    ResponseEntity<Object> updateBasketEntry(OrderItemDTO orderItemDTO);

    ResponseEntity<Object> deleteBasketEntry(long entryId);
}
