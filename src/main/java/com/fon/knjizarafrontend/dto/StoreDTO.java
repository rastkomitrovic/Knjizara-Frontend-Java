package com.fon.knjizarafrontend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("storeId")
    private Long storeId;
    @JsonProperty("storeName")
    private String storeName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("address")
    private String address;
    @JsonProperty("city")
    private CityDTO city;
    @JsonProperty("images")
    private List<StoreImageDTO> images;
}
