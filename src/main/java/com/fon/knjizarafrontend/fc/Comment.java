package com.fon.knjizarafrontend.fc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @JsonProperty("text")
    private String text;
    @JsonProperty("rating")
    private Float rating;
    @JsonProperty("bookId")
    private Long bookId;
    @JsonProperty("username")
    private String username;
}
