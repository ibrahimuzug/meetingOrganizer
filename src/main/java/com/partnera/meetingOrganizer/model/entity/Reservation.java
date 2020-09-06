package com.partnera.meetingOrganizer.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Data
@ToString
@EqualsAndHashCode
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "reservation_code")
    private String reservationCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_room_id", referencedColumnName = "id", nullable = false)
    private MeetingRoom meetingRoom;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @Column(name = "reservation_start_time")
    private LocalTime reservationStartTime;

    @Column(name = "reservation_end_time")
    private LocalTime reservationEndTime;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;
}


