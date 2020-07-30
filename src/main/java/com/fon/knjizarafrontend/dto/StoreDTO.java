package com.fon.knjizarafrontend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StoreDTO {
    private Long storeId;
    private String storeName;
    private String description;
    private String address;
    private CityDTO city;
    private List<StoreImageDTO> images;
}
