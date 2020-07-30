package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.dto.StoreImageDTO;
import org.springframework.http.ResponseEntity;

public interface StoreImageService {

    ResponseEntity<Object> saveStoreImage(StoreImageDTO storeImageDTO);

    ResponseEntity<StoreImageDTO[]> findStoreImagesByStoreId(long storeId);

    ResponseEntity<Object> deleteStoreImage(long imageId);
}
