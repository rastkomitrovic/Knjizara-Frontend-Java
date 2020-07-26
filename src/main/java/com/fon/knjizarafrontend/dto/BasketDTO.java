package com.fon.knjizarafrontend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketDTO {
    private Long basketId;
    private UserDTO user;
    private List<BasketEntryDTO> entries;
}
