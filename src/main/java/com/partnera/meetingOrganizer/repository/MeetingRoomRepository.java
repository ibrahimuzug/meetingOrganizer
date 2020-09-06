package com.partnera.meetingOrganizer.repository;

import com.partnera.meetingOrganizer.model.entity.MeetingRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRoomRepository extends CrudRepository<MeetingRoom, Long> {
}
