package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.dto.CityDTO;
import org.springframework.http.ResponseEntity;

public interface CityService {
    ResponseEntity<CityDTO[]> findAllCities();

    ResponseEntity<CityDTO> findCityByCityId(long cityId);

    ResponseEntity<CityDTO[]> findCitiesByCityNameContaining(String param);

    ResponseEntity<Object> saveCity(CityDTO cityDTO);

    ResponseEntity<Object> updateCity(CityDTO cityDTO);

    ResponseEntity<Object> deleteCity(long cityId);
}
