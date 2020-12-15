package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.dto.BookImageDTO;
import com.fon.knjizarafrontend.service.BookImageService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class BookImageServiceImpl implements BookImageService {

    @Resource
    private RestTemplate restTemplate;

    private final String api = ApiConstants.bookImagesApi;

    @Override
    public ResponseEntity<BookImageDTO[]> findBookImagesByBookId(long bookId) {
        return restTemplate.getForEntity(api + "/" + bookId, BookImageDTO[].class);
    }

    @Override
    public ResponseEntity<Object> saveBookImage(BookImageDTO bookImageDTO) {
        return restTemplate.postForEntity(api, bookImageDTO, Object.class);
    }

    @Override
    public ResponseEntity<Object> deleteBookImage(long bookImageId) {
        return restTemplate.exchange(api + "/" + bookImageId, HttpMethod.DELETE, null, Object.class);
    }
}
