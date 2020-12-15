package com.fon.knjizarafrontend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PublisherDTO {

    @JsonProperty("publisherId")
    private Long publisherId;

    @JsonProperty("publisherName")
    private String publisherName;
}
