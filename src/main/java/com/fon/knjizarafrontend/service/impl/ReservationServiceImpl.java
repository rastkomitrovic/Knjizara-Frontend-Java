package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.dto.ReservationDTO;
import com.fon.knjizarafrontend.service.ReservationService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Resource
    private RestTemplate restTemplate;

    private final String api = ApiConstants.reservationsApi;

    @Override
    public ResponseEntity<ReservationDTO> findReservationByReservationId(long reservationId) {
        return restTemplate.getForEntity(api + "/" + reservationId, ReservationDTO.class);
    }

    @Override
    public ResponseEntity<ReservationDTO> findReservationByEntryId(long entryId) {
        return restTemplate.getForEntity(api + "/entry/" + entryId, ReservationDTO.class);
    }

    @Override
    public ResponseEntity<RestPageImpl<ReservationDTO>> findReservationsPagingStatusSearch(int page, int size, String sort, String status) {
        ParameterizedTypeReference<RestPageImpl<ReservationDTO>> responseType = new ParameterizedTypeReference<RestPageImpl<ReservationDTO>>() {
        };
        return restTemplate.exchange(api + "/" + page + "/" + size + "/" + sort + "/" + status, HttpMethod.GET, null, responseType);
    }

    @Override
    public ResponseEntity<RestPageImpl<ReservationDTO>> findReservations(int page, int size, String sort) {
        ParameterizedTypeReference<RestPageImpl<ReservationDTO>> responseType = new ParameterizedTypeReference<RestPageImpl<ReservationDTO>>() {
        };
        return restTemplate.exchange(api + "/" + page + "/" + size + "/" + sort, HttpMethod.GET, null, responseType);
    }

    @Override
    public ResponseEntity<Object> saveReservation(ReservationDTO reservationDTO) {
        return restTemplate.postForEntity(api, reservationDTO, Object.class);
    }

    @Override
    public ResponseEntity<Object> updateReservation(ReservationDTO reservationDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ReservationDTO> entity = new HttpEntity<>(reservationDTO, headers);
        return restTemplate.exchange(api, HttpMethod.PUT, entity, Object.class);
    }

    @Override
    public ResponseEntity<Object> deleteReservation(long reservationId) {
        return restTemplate.exchange(api + "/" + reservationId, HttpMethod.DELETE, null, Object.class);
    }
}
