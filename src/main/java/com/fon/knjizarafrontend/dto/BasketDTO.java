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
public class BasketDTO {
    @JsonProperty("basketId")
    private Long basketId;
    @JsonProperty("user")
    private UserDTO user;
    @JsonProperty("entries")
    private List<BasketEntryDTO> entries;
}
