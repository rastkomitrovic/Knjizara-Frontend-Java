package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.dto.StoreDTO;
import org.springframework.http.ResponseEntity;

public interface StoreService {

    ResponseEntity<StoreDTO[]> findAllStores();

    ResponseEntity<RestPageImpl<StoreDTO>> findAllStoresPaging(int page, int size, String sort);

    ResponseEntity<RestPageImpl<StoreDTO>> findAllStoresPagingSearch(int page, int size, String sort, String param);

    ResponseEntity<StoreDTO> findStoreByStoreId(long storeId);

    ResponseEntity<Object> saveStore(StoreDTO storeDTO);

    ResponseEntity<Object> updateStore(StoreDTO storeDTO);

    ResponseEntity<Object> deleteStore(long storeId);
}
