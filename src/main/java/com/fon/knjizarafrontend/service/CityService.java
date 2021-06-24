package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.dto.CityDTO;
import org.springframework.http.ResponseEntity;

public interface CityService {
    ResponseEntity<CityDTO[]> findAllCities();

    ResponseEntity<CityDTO> findCityByCityId(long cityId);

}
