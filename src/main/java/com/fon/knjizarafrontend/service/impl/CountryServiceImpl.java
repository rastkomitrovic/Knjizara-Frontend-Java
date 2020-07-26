package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.dto.CountryDTO;
import com.fon.knjizarafrontend.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<CountryDTO> getCountryByCountryId(Long countryId) {
        return restTemplate.getForEntity(ApiConstants.countriesApi+"/"+countryId,CountryDTO.class);
    }

    @Override
    public ResponseEntity<List<CountryDTO>> findAllCountries() {
        return restTemplate.getForEntity(ApiConstants.countriesApi)
    }

    @Override
    public ResponseEntity<Object> saveCountry(CountryDTO countryDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Object> updateCountry(CountryDTO countryDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Object> deleteCountry(Long countryId) {
        return null;
    }
}
