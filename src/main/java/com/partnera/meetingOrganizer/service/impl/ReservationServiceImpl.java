package com.partnera.meetingOrganizer.service.impl;

import com.partnera.meetingOrganizer.dao.ReservationDAO;
import com.partnera.meetingOrganizer.model.Reservation;
import com.partnera.meetingOrganizer.service.ReservationService;

import java.util.Optional;

public class ReservationServiceImpl implements ReservationService {
    private final ReservationDAO reservationDAO;

    public ReservationServiceImpl(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }

    @Override
    public Optional<ReservationDAO> getReservationById(Long id) {
        Optional<Reservation> reservationOptional = reservationDAO.findById(id);
        return null;
    }

    @Override
    public void createReservation(ReservationDAO reservationDAO) {
        Reservation reservation = new Reservation();
        reservation.setEmployeeId(reservation.getEmployeeId());
        reservation.setMeetingRoomId(reservation.getMeetingRoomId());
        reservation.setReservationDate(reservation.getReservationDate());
        reservation.setReservationTime(reservation.getReservationTime());
        reservationDAO.save(reservation);
    }
}
