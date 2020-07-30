package com.fon.knjizarafrontend.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BasketEntryDTO {
    private Long entryId;
    private BookDTO book;
    private BasketDTO basket;
    private Long quantity;
    private Boolean active;
}
