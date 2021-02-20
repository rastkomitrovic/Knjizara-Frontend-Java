package com.fon.knjizarafrontend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDTO {
    @JsonProperty("orderId")
    private Long orderId;
    @JsonProperty("user")
    private UserDTO user;
    @JsonProperty("orderItems")
    private List<OrderItemDTO> orderItems;
    @JsonProperty("dateCreated")
    private Date dateCreated;
}
