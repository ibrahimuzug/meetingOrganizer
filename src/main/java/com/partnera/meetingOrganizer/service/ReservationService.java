package com.partnera.meetingOrganizer.service;

import com.partnera.meetingOrganizer.dao.ReservationDAO;

import java.util.Optional;

public interface ReservationService {
    Optional<ReservationDAO> getReservationById(Long id);

    void createReservation(ReservationDAO reservationDAO);
}
