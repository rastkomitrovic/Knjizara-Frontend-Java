package com.fon.knjizarafrontend.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO {
    private Long countryId;
    private String countryName;
    private String countryNameShort;
    private String description;
}
