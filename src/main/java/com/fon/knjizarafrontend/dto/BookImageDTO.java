package com.fon.knjizarafrontend.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookImageDTO {
    private Long imageId;
    private String imageEncoding;
    private String imageUrl;
    private BookDTO book;
}