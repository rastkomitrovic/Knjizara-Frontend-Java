package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.dto.PublisherDTO;
import org.springframework.http.ResponseEntity;

public interface PublisherService {

    ResponseEntity<PublisherDTO[]> getAllPublishers();

}
