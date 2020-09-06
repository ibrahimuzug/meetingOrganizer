package com.partnera.meetingOrganizer.repository;

import com.partnera.meetingOrganizer.model.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
