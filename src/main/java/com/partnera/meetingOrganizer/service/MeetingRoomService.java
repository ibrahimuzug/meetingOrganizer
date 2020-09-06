package com.partnera.meetingOrganizer.service;

import com.partnera.meetingOrganizer.model.request.MeetingRoomRequest;
import com.partnera.meetingOrganizer.model.response.MeetingRoomResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface MeetingRoomService {
    Optional<MeetingRoomResponse> getMeetingRoomById(Long id);

    Optional<List<MeetingRoomResponse>> getMeetingRooms();

    void createMeetingRoom(MeetingRoomRequest request);
}
