package com.fon.knjizarafrontend.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {
    private Long cityId;
    private String cityName;
    private String postalCode;
    private String description;
    private CountryDTO country;
}
