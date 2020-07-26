package com.fon.knjizarafrontend.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDTO {
    private Long genreId;
    private String genreName;
    private String description;
    private List<BookDTO> books;
}
