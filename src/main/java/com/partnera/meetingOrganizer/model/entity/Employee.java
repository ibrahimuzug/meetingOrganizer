package com.partnera.meetingOrganizer.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@ToString
@EqualsAndHashCode
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "employee_type")
    private EmployeeType employeeType;
}

