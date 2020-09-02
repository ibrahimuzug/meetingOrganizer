package com.partnera.meetingOrganizer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "reservation")
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    @OneToOne
    @MapsId
    private int meetingRoomId;

    @Column
    @OneToOne
    @MapsId
    private int employeeId;

    @Column
    private Time reservationTime;

    @Column
    private Date reservationDate;

    @Override
    public String toString() {
        return "Employee {" +
                "id=" + id +
                ", meetingRoomId='" + meetingRoomId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", reservationTime='" + reservationTime + '\'' +
                ", reservationDate=" + reservationDate +
                '}';
    }
}
