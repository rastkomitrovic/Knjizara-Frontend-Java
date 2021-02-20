package com.fon.knjizarafrontend.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private String orderId;
    private String username;
    private List<OrderRequestItem> items;
}
