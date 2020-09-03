package com.partnera.meetingOrganizer.service;

import com.partnera.meetingOrganizer.dao.MeetingRoomDAO;

import java.util.Optional;

public interface MeetingRoomService {
    Optional<MeetingRoomDAO> getMeetingRoomById(Long id);

    void createMeetingRoom(MeetingRoomDAO meetingRoomDAO);
}
