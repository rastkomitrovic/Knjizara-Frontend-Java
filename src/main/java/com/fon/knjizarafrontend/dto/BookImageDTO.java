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
public class BookImageDTO {
    @JsonProperty("imageId")
    private Long imageId;
    @JsonProperty("imageEncoding")
    private String imageEncoding;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("book")
    private BookDTO book;
}
