package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.dto.CountryDTO;
import org.springframework.http.ResponseEntity;

public interface CountryService {
    ResponseEntity<CountryDTO> getCountryByCountryId(Long countryId);

    ResponseEntity<CountryDTO[]> findAllCountries();

    ResponseEntity<Object> saveCountry(CountryDTO countryDTO);

    ResponseEntity<Object> updateCountry(CountryDTO countryDTO);

    ResponseEntity<Object> deleteCountry(Long countryId);
}
