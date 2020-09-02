package com.partnera.meetingOrganizer.model;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String title;

    @Column
    private Integer reservationAmount;


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReservationAmount() {
        return reservationAmount;
    }

    public void setReservationAmount(Integer reservationAmount) {
        this.reservationAmount = reservationAmount;
    }


    @Override
    public String toString() {
        return "Employee {" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", reservationAmount=" + getReservationAmount() +
                '}';
    }
}
