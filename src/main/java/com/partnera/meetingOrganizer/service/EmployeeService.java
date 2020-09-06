package com.partnera.meetingOrganizer.service;

import com.partnera.meetingOrganizer.model.request.EmployeeRequest;
import com.partnera.meetingOrganizer.model.response.EmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<EmployeeResponse> getEmployeeById(Long id);

    void createEmployee(EmployeeRequest request);

    Optional<List<EmployeeResponse>> getEmployees();
}
