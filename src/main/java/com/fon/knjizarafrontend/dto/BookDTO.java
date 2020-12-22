package com.fon.knjizarafrontend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDTO {
    @JsonProperty("bookId")
    private Long bookId;
    @JsonProperty("ISBN")
    private String ISBN;
    @JsonProperty("bookName")
    private String bookName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("stock")
    private Long stock;
    @JsonProperty("numberOfSoldCopies")
    private Long numberOfSoldCopies;
    @JsonProperty("language")
    private String language;
    @JsonProperty("images")
    private List<BookImageDTO> images;
    @JsonProperty("genres")
    private List<GenreDTO> genres;
    @JsonProperty("authors")
    private List<AuthorDTO> authors;
    @JsonProperty("comments")
    private List<CommentDTO> comments;
    @JsonProperty("rating")
    private float rating;
    @JsonProperty("publisher")
    private PublisherDTO publisher;
}
