package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.dto.GenreDTO;
import org.springframework.http.ResponseEntity;

public interface GenreService {

    ResponseEntity<GenreDTO[]> getAllGenresNoPaging();

}
