package com.partnera.meetingOrganizer.service;

import com.partnera.meetingOrganizer.dao.EmployeeDAO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface EmployeeService {

    Optional<EmployeeDAO> getEmployeeById(Long id);

    void createEmployee(EmployeeDAO employeeDAO);
}
