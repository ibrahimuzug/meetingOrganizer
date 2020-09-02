package com.partnera.meetingOrganizer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "meetingRoom")
@Getter
@Setter
public class MeetingRoomEntity {

    @Id
    @GeneratedValue
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
