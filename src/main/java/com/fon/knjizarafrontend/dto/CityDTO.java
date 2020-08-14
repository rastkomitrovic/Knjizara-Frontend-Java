package com.fon.knjizarafrontend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("cityId")
    private Long cityId;
    @JsonProperty("cityName")
    private String cityName;
    @JsonProperty("postalCode")
    private String postalCode;
    @JsonProperty("description")
    private String description;
    @JsonProperty("country")
    private CountryDTO country;
}
