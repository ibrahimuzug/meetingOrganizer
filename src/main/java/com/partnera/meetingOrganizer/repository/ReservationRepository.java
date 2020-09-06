package com.partnera.meetingOrganizer.repository;

import com.partnera.meetingOrganizer.model.entity.Employee;
import com.partnera.meetingOrganizer.model.entity.MeetingRoom;
import com.partnera.meetingOrganizer.model.entity.Reservation;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    @Query("select r from Reservation r where r.reservationCode=:reservationCode")
    Reservation getReservationByReservationCode(String reservationCode);

    @Query("select r from Reservation r where r.meetingRoom=:meetingRoom and r.reservationDate=:reservationDate and r.reservationStartTime between :startTime and :endTime")
    List<Reservation> getReservationByMeetingRoomAndReservationDateAndReservationStartTimeAndReservationEndTime(MeetingRoom meetingRoom, LocalDate reservationDate, LocalTime startTime, LocalTime endTime);

    @Query("select r from Reservation r where r.employee=:employee and r.reservationDate=:reservationDate")
    List<Reservation> getReservationByEmployeeAndReservationDate(Employee employee, LocalDate reservationDate);
}
