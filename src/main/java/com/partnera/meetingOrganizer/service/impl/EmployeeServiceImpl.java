package com.partnera.meetingOrganizer.service.impl;

import com.partnera.meetingOrganizer.repository.EmployeeRepository;
import com.partnera.meetingOrganizer.model.entity.Employee;
import com.partnera.meetingOrganizer.model.request.EmployeeRequest;
import com.partnera.meetingOrganizer.model.response.EmployeeResponse;
import com.partnera.meetingOrganizer.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Optional<EmployeeResponse> getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.map(this::convertEmployeeResponse);
    }

    private EmployeeResponse convertEmployeeResponse(Employee employee) {
        EmployeeResponse response = new EmployeeResponse();
        response.setId(employee.getId());
        response.setFirstName(employee.getFirstName());
        response.setLastName(employee.getLastName());
        response.setEmployeeType(employee.getEmployeeType());
        return response;
    }

    @Override
    public void createEmployee(EmployeeRequest request) {
        Employee employee = convertEmployee(request);
        employeeRepository.save(employee);
    }

    @Override
    public Optional<List<EmployeeResponse>> getEmployees() {
        List<EmployeeResponse> responseList = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> {
            EmployeeResponse response = convertEmployeeResponse(employee);
            responseList.add(response);
        });
        return Optional.of(responseList);
    }

    private Employee convertEmployee(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmployeeType(request.getEmployeeType());
        return employee;
    }
}
