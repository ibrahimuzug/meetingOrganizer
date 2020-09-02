package com.partnera.meetingOrganizer.dao;

import com.partnera.meetingOrganizer.model.MeetingRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRoomDAO extends CrudRepository<MeetingRoom, Long> {
}
