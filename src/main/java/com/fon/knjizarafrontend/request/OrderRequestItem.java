package com.fon.knjizarafrontend.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestItem {
    private Long bookId;
    private Long quantity;
}
