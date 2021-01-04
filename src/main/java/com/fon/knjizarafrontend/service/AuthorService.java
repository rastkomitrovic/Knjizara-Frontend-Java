package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.dto.AuthorDTO;
import org.springframework.http.ResponseEntity;

public interface AuthorService {
    ResponseEntity<AuthorDTO[]> findAllAuthorsNoPaging();

    ResponseEntity<RestPageImpl<AuthorDTO>> findAllAuthors(int page, int size, String sort);

    ResponseEntity<RestPageImpl<AuthorDTO>> findAllAuthorsSearch(int page, int size, String sort, String param);

    ResponseEntity<Object> saveAuthor(AuthorDTO authorDTO);

    ResponseEntity<Object> updateAuthor(AuthorDTO authorDTO);

    ResponseEntity<Object> deleteAuthor(long authorId);

    ResponseEntity<AuthorDTO> findAuthor(Long authorId);
}