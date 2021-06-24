package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.dto.CityDTO;
import com.fon.knjizarafrontend.service.CityService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class CityServiceImpl implements CityService {

    @Resource
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
}
