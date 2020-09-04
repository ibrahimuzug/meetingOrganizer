package com.partnera.meetingOrganizer.service;

import com.partnera.meetingOrganizer.dao.MeetingRoomDAO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface MeetingRoomService {
    Optional<MeetingRoomDAO> getMeetingRoomById(Long id);

    void createMeetingRoom(MeetingRoomDAO meetingRoomDAO);
}
