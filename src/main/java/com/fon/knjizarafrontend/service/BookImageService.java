package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.dto.BookImageDTO;
import org.springframework.http.ResponseEntity;

public interface BookImageService {
    ResponseEntity<BookImageDTO[]> findBookImagesByBookId(long bookId);

    ResponseEntity<Object> saveBookImage(BookImageDTO bookImageDTO);

    ResponseEntity<Object> deleteBookImage(long bookImageId);
}
