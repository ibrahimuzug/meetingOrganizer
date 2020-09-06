package com.partnera.meetingOrganizer.service.impl;

import com.partnera.meetingOrganizer.repository.EmployeeRepository;
import com.partnera.meetingOrganizer.repository.MeetingRoomRepository;
import com.partnera.meetingOrganizer.repository.ReservationRepository;
import com.partnera.meetingOrganizer.model.entity.Employee;
import com.partnera.meetingOrganizer.model.entity.EmployeeType;
import com.partnera.meetingOrganizer.model.entity.MeetingRoom;
import com.partnera.meetingOrganizer.model.entity.Reservation;
import com.partnera.meetingOrganizer.model.request.ReservationRequest;
import com.partnera.meetingOrganizer.model.response.ReservationResponse;
import com.partnera.meetingOrganizer.service.ReservationService;
import com.partnera.meetingOrganizer.utilty.RandomCodeGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private static final LocalTime MIN = LocalTime.of(8, 0);
    private static final LocalTime MAX = LocalTime.of(17, 0);

    private final ReservationRepository reservationRepository;
    private final EmployeeRepository employeeRepository;
    private final MeetingRoomRepository meetingRoomRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  EmployeeRepository employeeRepository,
                                  MeetingRoomRepository meetingRoomRepository) {
        this.reservationRepository = reservationRepository;
        this.employeeRepository = employeeRepository;
        this.meetingRoomRepository = meetingRoomRepository;
    }

    @Override
    public Optional<ReservationResponse> getReservationByCode(String reservationCode) {
        Reservation reservation = reservationRepository.getReservationByReservationCode(reservationCode);
        return Optional.of(convertReservationResponse(reservation));
    }

    private ReservationResponse convertReservationResponse(Reservation reservation) {
        ReservationResponse response = new ReservationResponse();
        response.setEmployeeFirstName(reservation.getEmployee().getFirstName());
        response.setEmployeeLastName(reservation.getEmployee().getLastName());
        response.setEmployeeType(reservation.getEmployee().getEmployeeType());
        response.setMeetingRoomName(reservation.getMeetingRoom().getName());
        response.setReservationCode(reservation.getReservationCode());
        response.setReservationDate(reservation.getReservationDate());
        response.setReservationStartTime(reservation.getReservationStartTime());
        response.setReservationEndTime(reservation.getReservationEndTime());
        return response;
    }

    @Override
    public String createReservation(ReservationRequest request) {
        if (!validateReservationDateTime(request)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation Not Available For Date Time!");
        }

        Optional<Employee> employeeOptional = employeeRepository.findById(request.getEmployeeId());
        if (!employeeOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found!");
        }

        Optional<MeetingRoom> meetingRoomOptional = meetingRoomRepository.findById(request.getMeetingRoomId());
        if (!meetingRoomOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Meeting Room Not Found!");
        }

        Employee employee = employeeOptional.get();
        if (!EmployeeType.TEAM_LEAD.equals(employee.getEmployeeType())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Employee Will Not Be Able To Create Reservation!");
        }

        MeetingRoom meetingRoom = meetingRoomOptional.get();
        List<Reservation> reservationByDateTime = reservationRepository.getReservationByMeetingRoomAndReservationDateAndReservationStartTimeAndReservationEndTime(meetingRoom, request.getReservationDate(), request.getReservationStartTime(), request.getReservationEndTime());
        if (!reservationByDateTime.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Meeting Room Not Available!");
        }

        List<Reservation> reservationByEmployeeAndReservationDate = reservationRepository.getReservationByEmployeeAndReservationDate(employee, request.getReservationDate());
        if (reservationByEmployeeAndReservationDate.size() >= 3) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Employee Will Not Be Able To Reservation More Than 3!");
        }

        Reservation reservation = convertReservation(request, employee, meetingRoom);
        reservationRepository.save(reservation);
        return reservation.getReservationCode();
    }

    private boolean validateReservationDateTime(ReservationRequest request) {
        if (request.getReservationDate().getDayOfWeek() == DayOfWeek.SATURDAY||
                request.getReservationDate().getDayOfWeek() == DayOfWeek.SUNDAY) {
            return false;
        }

        if(request.getReservationStartTime().isBefore(MIN) ||
                request.getReservationStartTime().isAfter(MAX)) {
            return false;
        }

        if(request.getReservationEndTime().isBefore(MIN) ||
                request.getReservationEndTime().isAfter(MAX)) {
            return false;
        }

        if (request.getReservationStartTime().isAfter(request.getReservationEndTime()) ||
                request.getReservationStartTime().equals(request.getReservationEndTime())) {
            return false;
        }

        long hours = Duration.between(request.getReservationStartTime(), request.getReservationEndTime()).toHours();
        if (hours > 2) {
            return false;
        }
        return true;
    }

    private Reservation convertReservation(ReservationRequest request, Employee employee, MeetingRoom meetingRoom) {
        String reservationCode = RandomCodeGenerator.generate();

        Reservation reservation = new Reservation();
        reservation.setEmployee(employee);
        reservation.setMeetingRoom(meetingRoom);
        reservation.setReservationCode(reservationCode);
        reservation.setReservationDate(request.getReservationDate());
        reservation.setReservationStartTime(request.getReservationStartTime());
        reservation.setReservationEndTime(request.getReservationEndTime());
        return reservation;
    }


}
