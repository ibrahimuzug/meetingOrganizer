package com.partnera.meetingOrganizer.service;

import com.partnera.meetingOrganizer.dao.EmployeeDAO;

import java.util.Optional;

public interface EmployeeService {

    Optional<EmployeeDAO> getEmployeeById(Long id);

    void createEmployee(EmployeeDAO employeeDAO);
}
