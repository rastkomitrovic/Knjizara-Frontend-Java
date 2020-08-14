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
public class GenreDTO {
    @JsonProperty("genreId")
    private Long genreId;
    @JsonProperty("genreName")
    private String genreName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("books")
    private List<BookDTO> books;
}
