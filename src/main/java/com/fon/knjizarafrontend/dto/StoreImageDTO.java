package com.fon.knjizarafrontend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StoreImageDTO {
    private Long imageId;
    private String imageEncoding;
    private String imageUrl;
    private StoreDTO store;
}
