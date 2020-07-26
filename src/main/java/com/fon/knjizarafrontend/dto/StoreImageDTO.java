package com.fon.knjizarafrontend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreImageDTO {
    private Long imageId;
    private String imageEncoding;
    private String imageUrl;
    private StoreDTO store;
}
