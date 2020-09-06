package com.partnera.meetingOrganizer.service.impl;

import com.partnera.meetingOrganizer.repository.MeetingRoomRepository;
import com.partnera.meetingOrganizer.model.entity.MeetingRoom;
import com.partnera.meetingOrganizer.model.request.MeetingRoomRequest;
import com.partnera.meetingOrganizer.model.response.MeetingRoomResponse;
import com.partnera.meetingOrganizer.service.MeetingRoomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {
    private final MeetingRoomRepository meetingRoomRepository;

    public MeetingRoomServiceImpl(MeetingRoomRepository meetingRoomRepository) {
        this.meetingRoomRepository = meetingRoomRepository;
    }

    @Override
    public Optional<MeetingRoomResponse> getMeetingRoomById(Long id) {
        Optional<MeetingRoom> meetingRoomOptional = meetingRoomRepository.findById(id);
        return meetingRoomOptional.map(this::convertMeetingRoomResponse);
    }

    private MeetingRoomResponse convertMeetingRoomResponse(MeetingRoom meetingRoom) {
        MeetingRoomResponse response = new MeetingRoomResponse();
        response.setId(meetingRoom.getId());
        response.setName(meetingRoom.getName());
        response.setCapacity(meetingRoom.getCapacity());
        return response;
    }

    @Override
    public Optional<List<MeetingRoomResponse>> getMeetingRooms() {
        List<MeetingRoomResponse> responseList = new ArrayList<>();
        meetingRoomRepository.findAll().forEach(meetingRoom -> {
            MeetingRoomResponse response = convertMeetingRoomResponse(meetingRoom);
            responseList.add(response);
        });
        return Optional.of(responseList);
    }

    @Override
    public void createMeetingRoom(MeetingRoomRequest request) {
        MeetingRoom meetingRoom = convertMeetingRoom(request);
        meetingRoomRepository.save(meetingRoom);
    }

    private MeetingRoom convertMeetingRoom(MeetingRoomRequest request) {
        MeetingRoom meetingRoom = new MeetingRoom();
        meetingRoom.setName(request.getName());
        meetingRoom.setCapacity(request.getCapacity());
        return meetingRoom;
    }
}
