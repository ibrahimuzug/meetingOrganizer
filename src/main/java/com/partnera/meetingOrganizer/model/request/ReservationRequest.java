package com.partnera.meetingOrganizer.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ReservationRequest {

    @NotNull
    private Long employeeId;
    @NotNull
    private Long meetingRoomId;

    @NotNull
    private LocalTime reservationStartTime;
    @NotNull
    private LocalTime reservationEndTime;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate reservationDate;
}
