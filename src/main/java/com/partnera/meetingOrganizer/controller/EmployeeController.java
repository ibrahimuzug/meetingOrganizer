package com.partnera.meetingOrganizer.controller;

import com.partnera.meetingOrganizer.model.request.EmployeeRequest;
import com.partnera.meetingOrganizer.model.response.EmployeeResponse;
import com.partnera.meetingOrganizer.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<EmployeeResponse> getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public @ResponseBody Optional<List<EmployeeResponse>> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping
    public void createEmployee(@RequestBody @Valid EmployeeRequest request) {
        employeeService.createEmployee(request);
    }
}
