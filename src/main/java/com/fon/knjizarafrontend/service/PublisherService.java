package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.dto.PublisherDTO;
import org.springframework.http.ResponseEntity;

public interface PublisherService {

    ResponseEntity<PublisherDTO[]> getAllPublishers();

    ResponseEntity<PublisherDTO> findPublisherByPublisherId(Long publisherId);

    ResponseEntity<Object> savePublisher(PublisherDTO publisher);

    ResponseEntity<Object> updatePublisher(PublisherDTO publisher);

    ResponseEntity<Object> deletePublisher(Long publisherId);
}
