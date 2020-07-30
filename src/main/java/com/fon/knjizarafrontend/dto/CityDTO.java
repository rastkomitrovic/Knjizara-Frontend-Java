package com.fon.knjizarafrontend.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.TestOnly;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CityDTO {
    private Long cityId;
    private String cityName;
    private String postalCode;
    private String description;
    private CountryDTO country;
}
