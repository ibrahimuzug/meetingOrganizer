package com.partnera.meetingOrganizer.model.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MeetingRoomRequest {

    @NotBlank
    private String name;

    @NotNull
    @Min(value = 1)
    @Max(value = 7)
    private Integer capacity;
}
