package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.dto.CommentDTO;
import com.fon.knjizarafrontend.fc.Comment;
import org.springframework.http.ResponseEntity;

public interface CommentService {
    ResponseEntity<CommentDTO[]> findCommentsByBookId(long bookId);

    ResponseEntity<Object> saveComment(Comment comment);

    ResponseEntity<Object> deleteComment(long commentId);
}
