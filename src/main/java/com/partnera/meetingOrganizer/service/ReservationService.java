package com.partnera.meetingOrganizer.service;

import com.partnera.meetingOrganizer.dao.ReservationDAO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ReservationService {
    Optional<ReservationDAO> getReservationById(Long id);

    void createReservation(ReservationDAO reservationDAO);
}
