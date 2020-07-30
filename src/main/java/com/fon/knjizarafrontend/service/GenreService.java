package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.dto.GenreDTO;
import org.springframework.http.ResponseEntity;

public interface GenreService {

    ResponseEntity<GenreDTO[]> getAllGenresNoPaging();

    ResponseEntity<GenreDTO> findGenreByGenreId(long genreId);

    ResponseEntity<RestPageImpl<GenreDTO>> findAllGenresPaging(int page, int size, String sort);

    ResponseEntity<RestPageImpl<GenreDTO>> findAllGenresPagingSearch(int page, int size, String sort, String search);

    ResponseEntity<Object> saveGenre(GenreDTO genreDTO);

    ResponseEntity<Object> updateGenre(GenreDTO genreDTO);

    ResponseEntity<Object> deleteGenre(long genreId);
}
