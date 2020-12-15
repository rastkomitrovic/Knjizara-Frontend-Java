package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.dto.CommentDTO;
import com.fon.knjizarafrontend.service.CommentService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private RestTemplate restTemplate;

    private final String api = ApiConstants.commentsApi;

    @Override
    public ResponseEntity<CommentDTO[]> findCommentsByBookId(long bookId) {
        return restTemplate.getForEntity(api + "/" + bookId, CommentDTO[].class);
    }

    @Override
    public ResponseEntity<Object> saveComment(CommentDTO commentDTO) {
        return restTemplate.postForEntity(api, commentDTO, Object.class);
    }

    @Override
    public ResponseEntity<Object> updateComment(CommentDTO commentDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CommentDTO> entity = new HttpEntity<>(commentDTO, headers);
        return restTemplate.exchange(api, HttpMethod.PUT, null, Object.class);
    }

    @Override
    public ResponseEntity<Object> deleteComment(long commentId) {
        return restTemplate.exchange(api + "/" + commentId, HttpMethod.DELETE, null, Object.class);
    }
}
