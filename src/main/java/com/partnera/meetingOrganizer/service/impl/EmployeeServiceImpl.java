package com.partnera.meetingOrganizer.service.impl;

import com.partnera.meetingOrganizer.dao.EmployeeDAO;
import com.partnera.meetingOrganizer.model.Employee;
import com.partnera.meetingOrganizer.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Optional<EmployeeDAO> getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeDAO.findById(id);
        return null;
    }

    @Override
    public void createEmployee(EmployeeDAO employeeDAO) {
        Employee employee = new Employee();
        employee.setName(employee.getName());
        employee.setSurname(employee.getSurname());
        employee.setTitle(employee.getTitle());
        employee.setReservationAmount(employee.getReservationAmount());
        employeeDAO.save(employee);
    }
}
