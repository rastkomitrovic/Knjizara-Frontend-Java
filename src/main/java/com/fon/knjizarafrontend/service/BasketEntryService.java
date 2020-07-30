package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.dto.BasketEntryDTO;
import org.springframework.http.ResponseEntity;

public interface BasketEntryService {
    ResponseEntity<RestPageImpl<BasketEntryDTO>> findEntriesByBasketId(long basketId, int page, int size, String sort, boolean active);

    ResponseEntity<Object> saveBasketEntry(BasketEntryDTO basketEntryDTO);

    ResponseEntity<Object> updateBasketEntry(BasketEntryDTO basketEntryDTO);

    ResponseEntity<Object> deleteBasketEntry(long entryId);
}
