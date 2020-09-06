package com.partnera.meetingOrganizer.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@ToString
@EqualsAndHashCode
@Table(name = "meeting_room")
public class MeetingRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private Integer capacity;
}
