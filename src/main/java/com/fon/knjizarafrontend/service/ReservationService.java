package com.fon.knjizarafrontend.service;

import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.dto.ReservationDTO;
import org.springframework.http.ResponseEntity;

public interface ReservationService {

    ResponseEntity<ReservationDTO> findReservationByReservationId(long reservationId);

    ResponseEntity<ReservationDTO> findReservationByEntryId(long entryId);

    ResponseEntity<RestPageImpl<ReservationDTO>> findReservationsPagingStatusSearch(int page, int size, String sort, String status);

    ResponseEntity<RestPageImpl<ReservationDTO>> findReservations(int page, int size, String sort);

    ResponseEntity<Object> saveReservation(ReservationDTO reservationDTO);

    ResponseEntity<Object> updateReservation(ReservationDTO reservationDTO);

    ResponseEntity<Object> deleteReservation(long reservationId);
}
