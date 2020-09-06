package com.partnera.meetingOrganizer.service;

import com.partnera.meetingOrganizer.model.request.ReservationRequest;
import com.partnera.meetingOrganizer.model.response.ReservationResponse;

import java.util.Optional;

public interface ReservationService {

    Optional<ReservationResponse> getReservationByCode(String reservationCode);

    String createReservation(ReservationRequest request);

}
