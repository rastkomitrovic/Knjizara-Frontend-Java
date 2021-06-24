package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.dto.StoreDTO;
import org.springframework.http.ResponseEntity;

public interface StoreService {

    ResponseEntity<StoreDTO[]> findAllStores();

}
