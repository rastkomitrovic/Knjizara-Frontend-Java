package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.dto.AuthorDTO;
import com.fon.knjizarafrontend.dto.BookDTO;
import com.fon.knjizarafrontend.fc.Book;
import org.springframework.http.ResponseEntity;

public interface BookService {
    ResponseEntity<BookDTO[]> getAllBooks();

    ResponseEntity<BookDTO> findBookByBookId(long bookId);

    ResponseEntity<RestPageImpl<BookDTO>> findBooksPaging(int page, int size, String sort);

    ResponseEntity<RestPageImpl<BookDTO>> findBooksPagingSearch(int page, int size, String sort, String param);

    ResponseEntity<RestPageImpl<BookDTO>> findBooksByAuthor(Long authorId, int page, int size, String sort);

    ResponseEntity<RestPageImpl<BookDTO>> findBooksByGenre(Long genreId, int page, int size, String sort);

    ResponseEntity<RestPageImpl<BookDTO>> findBooksByPublisher(Long publisherId, int page, int size, String sort);

    ResponseEntity<Object> saveBook(Book book);

    ResponseEntity<BookDTO[]> getAllBooksBestReviews();
}
