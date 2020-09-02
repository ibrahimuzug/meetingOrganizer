package com.partnera.meetingOrganizer.dao;

import com.partnera.meetingOrganizer.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDAO extends CrudRepository<Reservation, Long> {
}
