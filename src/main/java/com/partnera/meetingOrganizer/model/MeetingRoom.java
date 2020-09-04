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
public class MeetingRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer capacity;

    @Override
    public String toString() {
        return "Employee {" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", capacity='" + getCapacity() + '\'' +
                '}';
    }

}
