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
public class ReservationDTO {
    @JsonProperty("reservationId")
    private Long reservationId;
    @JsonProperty("entry")
    private BasketEntryDTO entry;
    @JsonProperty("status")
    private String status;
}
