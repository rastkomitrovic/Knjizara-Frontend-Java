package com.fon.knjizarafrontend.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketEntryDTO {
    private Long entryId;
    private BookDTO book;
    private BasketDTO basket;
    private Long quantity;
    private Boolean active;
}
