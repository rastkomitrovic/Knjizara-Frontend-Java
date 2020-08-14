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
public class BasketEntryDTO {
    @JsonProperty("entryId")
    private Long entryId;
    @JsonProperty("book")
    private BookDTO book;
    @JsonProperty("basket")
    private BasketDTO basket;
    @JsonProperty("quantity")
    private Long quantity;
    @JsonProperty("active")
    private Boolean active;
}
