package com.partnera.meetingOrganizer.controller;

import com.partnera.meetingOrganizer.dao.EmployeeDAO;
import com.partnera.meetingOrganizer.model.Employee;
import com.partnera.meetingOrganizer.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<EmployeeDAO> getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/create")
    public void createEmployee(@RequestBody EmployeeDAO employeeDAO) {
        Employee employee = new Employee();
        if (employee.getTitle() == "Ekip Lideri") {
            employee.setReservationStatus(true);
            employee.setReservationAmount(employee.getReservationAmount()-1);
        }
        employeeService.createEmployee(employeeDAO);
    }
}
