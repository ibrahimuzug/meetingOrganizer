package com.partnera.meetingOrganizer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Setter
@Getter
public class EmployeeEntity {

    @Id
    @GeneratedValue
    @Column
    @OneToOne
    private Integer id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String title;

    @Column
    private Integer reservationAmount;

    @Override
    public String toString() {
        return "Employee {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", title='" + title + '\'' +
                ", reservationAmount=" + reservationAmount +
                '}';
    }

}
