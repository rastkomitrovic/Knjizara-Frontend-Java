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
public class CountryDTO {
    @JsonProperty("countryId")
    private Long countryId;
    @JsonProperty("countryName")
    private String countryName;
    @JsonProperty("countryNameShort")
    private String countryNameShort;
    @JsonProperty("description")
    private String description;
}
