package com.fon.knjizarafrontend.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Long commentId;
    private String text;
    private UserDTO user;
    private BookDTO book;
}
