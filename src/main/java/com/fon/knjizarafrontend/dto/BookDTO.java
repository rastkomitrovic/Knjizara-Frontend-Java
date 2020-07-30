package com.fon.knjizarafrontend.dto;

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
    private Long bookId;
    private String ISBN;
    private String bookName;
    private String description;
    private Double price;
    private Long stock;
    private Long numberOfSoldCopies;
    private String language;
    private List<BookImageDTO> images;
    private List<GenreDTO> genres;
    private List<AuthorDTO> authors;
}
