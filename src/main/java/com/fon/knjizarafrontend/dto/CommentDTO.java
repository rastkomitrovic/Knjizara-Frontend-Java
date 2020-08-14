package com.fon.knjizarafrontend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentDTO {
    @JsonProperty("commentId")
    private Long commentId;
    @JsonProperty("text")
    private String text;
    @JsonProperty("rating")
    private float rating;
    @JsonProperty("user")
    private UserDTO user;
    @JsonProperty("book")
    private BookDTO book;
}
