package com.partnera.meetingOrganizer.model.response;

import com.partnera.meetingOrganizer.model.entity.EmployeeType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployeeResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private EmployeeType employeeType;
}
