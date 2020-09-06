package com.partnera.meetingOrganizer.controller;

import com.partnera.meetingOrganizer.model.request.ReservationRequest;
import com.partnera.meetingOrganizer.model.response.ReservationResponse;
import com.partnera.meetingOrganizer.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{reservationCode}")
    public @ResponseBody Optional<ReservationResponse> getReservationById(@PathVariable("reservationCode") String reservationCode) {
        return reservationService.getReservationByCode(reservationCode);
    }

    @PostMapping
    public @ResponseBody String createReservation(@Valid @RequestBody ReservationRequest request) {
        return reservationService.createReservation(request);
    }
}

