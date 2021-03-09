package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.dto.BookDTO;
import com.fon.knjizarafrontend.fc.Book;
import com.fon.knjizarafrontend.service.BookService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private RestTemplate restTemplate;

    private final String api = ApiConstants.booksApi;

    @Override
    public ResponseEntity<BookDTO[]> getAllBooks() {
        return restTemplate.getForEntity(api, BookDTO[].class);
    }

    @Override
    public ResponseEntity<BookDTO> findBookByBookId(long bookId) {
        return restTemplate.getForEntity(api + "/" + bookId, BookDTO.class);
    }

    @Override
    public ResponseEntity<RestPageImpl<BookDTO>> findBooksPaging(int page, int size, String sort) {
        ParameterizedTypeReference<RestPageImpl<BookDTO>> responseType = new ParameterizedTypeReference<RestPageImpl<BookDTO>>() {
        };
        return restTemplate.exchange(api + "/" + page + "/" + size + "/" + sort, HttpMethod.GET, null, responseType);
    }

    @Override
    public ResponseEntity<RestPageImpl<BookDTO>> findBooksPagingSearch(int page, int size, String sort, String param) {
        ParameterizedTypeReference<RestPageImpl<BookDTO>> responseType = new ParameterizedTypeReference<RestPageImpl<BookDTO>>() {
        };
        return restTemplate.exchange(api + "/" + page + "/" + size + "/" + sort + "/" + param, HttpMethod.GET, null, responseType);
    }

    @Override
    public ResponseEntity<RestPageImpl<BookDTO>> findBooksByAuthor(Long authorId, int page, int size, String sort) {
        ParameterizedTypeReference<RestPageImpl<BookDTO>> responseType = new ParameterizedTypeReference<RestPageImpl<BookDTO>>() {
        };
        return restTemplate.exchange(api + "/authorSearch/"+authorId+"/" + page + "/" + size + "/" + sort, HttpMethod.GET, null, responseType);
    }

    @Override
    public ResponseEntity<RestPageImpl<BookDTO>> findBooksByGenre(Long genreId, int page, int size, String sort) {
        ParameterizedTypeReference<RestPageImpl<BookDTO>> responseType= new ParameterizedTypeReference<RestPageImpl<BookDTO>>() {
        };
        return restTemplate.exchange(api+"/genreSearch/"+genreId+"/" + page + "/" + size + "/" + sort, HttpMethod.GET, null, responseType);
    }

    @Override
    public ResponseEntity<RestPageImpl<BookDTO>> findBooksByPublisher(Long publisherId, int page, int size, String sort) {
        ParameterizedTypeReference<RestPageImpl<BookDTO>> responseType= new ParameterizedTypeReference<RestPageImpl<BookDTO>>() {
        };
        return restTemplate.exchange(api+"/publisherSearch/"+publisherId+"/" + page + "/" + size + "/" + sort, HttpMethod.GET, null, responseType);
    }

    @Override
    public ResponseEntity<Object> saveBook(Book book) {
        return restTemplate.postForEntity(api, book, Object.class);
    }

    @Override
    public ResponseEntity<BookDTO[]> getAllBooksBestReviews() {
        return restTemplate.getForEntity(api+"/top12", BookDTO[].class);
    }
}
