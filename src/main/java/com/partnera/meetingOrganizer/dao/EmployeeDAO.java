package com.partnera.meetingOrganizer.dao;

import com.partnera.meetingOrganizer.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends CrudRepository<Employee, Long> {
}
