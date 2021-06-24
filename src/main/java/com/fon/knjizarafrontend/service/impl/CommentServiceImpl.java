package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.dto.CommentDTO;
import com.fon.knjizarafrontend.fc.Comment;
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
    public ResponseEntity<Object> saveComment(Comment comment) {
        return restTemplate.postForEntity(api, comment, Object.class);
    }

    @Override
    public ResponseEntity<Object> deleteComment(long commentId) {
        return restTemplate.exchange(api + "/" + commentId, HttpMethod.DELETE, null, Object.class);
    }
}
