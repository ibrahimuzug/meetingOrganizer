package com.partnera.meetingOrganizer.service.impl;

import com.partnera.meetingOrganizer.dao.MeetingRoomDAO;
import com.partnera.meetingOrganizer.model.MeetingRoom;
import com.partnera.meetingOrganizer.service.MeetingRoomService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {
    private final MeetingRoomDAO meetingRoomDAO;

    public MeetingRoomServiceImpl(MeetingRoomDAO meetingRoomDAO) {
        this.meetingRoomDAO = meetingRoomDAO;
    }

    @Override
    public Optional<MeetingRoomDAO> getMeetingRoomById(Long id) {
        Optional<MeetingRoom> meetingRoomOptional = meetingRoomDAO.findById(id);
        return null;
    }

    @Override
    public void createMeetingRoom(MeetingRoomDAO meetingRoomDAO) {
        MeetingRoom meetingRoom = new MeetingRoom();
        meetingRoom.setName(meetingRoom.getName());
        meetingRoom.setCapacity(meetingRoom.getCapacity());
        meetingRoomDAO.save(meetingRoom);
    }
}
