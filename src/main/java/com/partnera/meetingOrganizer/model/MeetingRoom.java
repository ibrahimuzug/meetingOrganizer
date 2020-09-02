package com.partnera.meetingOrganizer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "meetingRoom")
@Getter
@Setter
public class MeetingRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    @OneToOne
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer capacity;

    @Override
    public String toString() {
        return "Employee {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }

}
