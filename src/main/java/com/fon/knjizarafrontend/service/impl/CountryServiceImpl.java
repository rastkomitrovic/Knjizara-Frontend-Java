package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.dto.CountryDTO;
import com.fon.knjizarafrontend.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private RestTemplate restTemplate;

    private final String api = ApiConstants.countriesApi;

    @Override
    public ResponseEntity<CountryDTO> getCountryByCountryId(Long countryId) {
        return restTemplate.getForEntity(api + "/" + countryId, CountryDTO.class);
    }

    @Override
    public ResponseEntity<CountryDTO[]> findAllCountries() {
        return restTemplate.getForEntity(api, CountryDTO[].class);
    }

    @Override
    public ResponseEntity<Object> saveCountry(CountryDTO countryDTO) {
        return restTemplate.postForEntity(api, countryDTO, Object.class);
    }

    @Override
    public ResponseEntity<Object> updateCountry(CountryDTO countryDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CountryDTO> httpEntity = new HttpEntity<>(countryDTO, headers);
        return restTemplate.exchange(api, HttpMethod.PUT, httpEntity, Object.class);
    }

    @Override
    public ResponseEntity<Object> deleteCountry(Long countryId) {
        return restTemplate.exchange(api + "/" + countryId, HttpMethod.DELETE, null, Object.class);
    }
}
