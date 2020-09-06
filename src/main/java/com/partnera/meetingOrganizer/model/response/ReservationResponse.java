package com.partnera.meetingOrganizer.model.response;

import com.partnera.meetingOrganizer.model.entity.EmployeeType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ReservationResponse {

    private String reservationCode;
    private LocalTime reservationStartTime;
    private LocalTime reservationEndTime;
    private LocalDate reservationDate;
    private String meetingRoomName;
    private String employeeFirstName;
    private String employeeLastName;
    private EmployeeType employeeType;
}
