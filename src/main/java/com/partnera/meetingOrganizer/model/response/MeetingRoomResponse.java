package com.partnera.meetingOrganizer.model.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MeetingRoomResponse {

    private Long id;
    private String name;
    private Integer capacity;
}
