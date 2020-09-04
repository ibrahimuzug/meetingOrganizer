package com.partnera.meetingOrganizer.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@Table
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

    @Column
    private Boolean reservationStatus;

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
