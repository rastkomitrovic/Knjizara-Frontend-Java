package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.dto.CityDTO;
import com.fon.knjizarafrontend.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private RestTemplate restTemplate;

    private final String api = ApiConstants.citiesApi;

    @Override
    public ResponseEntity<CityDTO[]> findAllCities() {
        return restTemplate.getForEntity(api, CityDTO[].class);
    }

    @Override
    public ResponseEntity<CityDTO> findCityByCityId(long cityId) {
        return restTemplate.getForEntity(api + "/" + cityId, CityDTO.class);
    }

    @Override
    public ResponseEntity<CityDTO[]> findCitiesByCityNameContaining(String param) {
        return restTemplate.getForEntity(api + "/?param=" + param, CityDTO[].class);
    }

    @Override
    public ResponseEntity<Object> saveCity(CityDTO cityDTO) {
        return restTemplate.postForEntity(api, cityDTO, Object.class);
    }

    @Override
    public ResponseEntity<Object> updateCity(CityDTO cityDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CityDTO> entity = new HttpEntity<>(cityDTO, headers);
        return restTemplate.exchange(api, HttpMethod.PUT, entity, Object.class);
    }

    @Override
    public ResponseEntity<Object> deleteCity(long cityId) {
        return restTemplate.exchange(api + "/" + cityId, HttpMethod.DELETE, null, Object.class);
    }
}
