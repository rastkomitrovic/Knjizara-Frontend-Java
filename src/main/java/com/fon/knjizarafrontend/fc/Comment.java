package com.fon.knjizarafrontend.fc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private String username;
    private Long bookId;
    private String text;
    private Integer rating;
}
