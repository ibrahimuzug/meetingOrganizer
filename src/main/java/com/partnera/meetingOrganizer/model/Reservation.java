package com.partnera.meetingOrganizer.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private int meetingRoomId;

    @Column
    @MapsId
    private int employeeId;

    @Column
    private Time reservationTime;

    @Column
    private Date reservationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMeetingRoomId() {
        return meetingRoomId;
    }

    public void setMeetingRoomId(int meetingRoomId) {
        this.meetingRoomId = meetingRoomId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Time getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Time reservationTime) {
        this.reservationTime = reservationTime;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "id=" + getId() +
                ", meetingRoomId='" + getMeetingRoomId() + '\'' +
                ", employeeId='" + getEmployeeId() + '\'' +
                ", reservationTime='" + getReservationTime() + '\'' +
                ", reservationDate=" + getReservationDate() +
                '}';
    }
}
