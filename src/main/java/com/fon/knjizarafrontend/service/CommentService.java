package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.dto.CommentDTO;
import org.springframework.http.ResponseEntity;

public interface CommentService {
    ResponseEntity<CommentDTO[]> findCommentsByBookId(long bookId);

    ResponseEntity<Object> saveComment(CommentDTO commentDTO);

    ResponseEntity<Object> updateComment(CommentDTO commentDTO);

    ResponseEntity<Object> deleteComment(long commentId);
}
