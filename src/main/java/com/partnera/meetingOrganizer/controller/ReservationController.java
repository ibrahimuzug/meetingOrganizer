package com.partnera.meetingOrganizer.controller;

import com.partnera.meetingOrganizer.dao.MeetingRoomDAO;
import com.partnera.meetingOrganizer.dao.ReservationDAO;
import com.partnera.meetingOrganizer.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<ReservationDAO> getReservationById(@PathVariable("id") Long id) {
        return reservationService.getReservationById(id);
    }

    @PostMapping("/create")
    public void createReservation(@RequestBody ReservationDAO reservationDAO) {
        reservationService.createReservation(reservationDAO);
    }
}
