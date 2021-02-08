package com.fon.knjizarafrontend.fc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @JsonProperty("isbn")
    private String isbn;
    @JsonProperty("bookName")
    private String bookName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("stock")
    private Long stock;
    @JsonProperty("language")
    private String language;
    @JsonProperty("images")
    private List<String> images;
    @JsonProperty("genres")
    private List<Long> genres;
    @JsonProperty("authors")
    private List<Long> authors;
    @JsonProperty("publisher")
    private Long publisher;
}
