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
public class OrderItemDTO {
    @JsonProperty("itemId")
    private Long itemId;
    @JsonProperty("book")
    private BookDTO book;
    @JsonProperty("order")
    private OrderDTO order;
    @JsonProperty("quantity")
    private Long quantity;
}
