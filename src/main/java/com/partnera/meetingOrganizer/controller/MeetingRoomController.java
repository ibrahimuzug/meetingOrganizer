package com.partnera.meetingOrganizer.controller;

import com.partnera.meetingOrganizer.model.request.MeetingRoomRequest;
import com.partnera.meetingOrganizer.model.response.MeetingRoomResponse;
import com.partnera.meetingOrganizer.service.MeetingRoomService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/meeting-room")
public class MeetingRoomController {
    private final MeetingRoomService meetingRoomService;

    public MeetingRoomController(MeetingRoomService meetingRoomService) {
        this.meetingRoomService = meetingRoomService;
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<MeetingRoomResponse> getMeetingRoomById(@PathVariable("id") Long id) {
        return meetingRoomService.getMeetingRoomById(id);
    }

    @GetMapping
    public @ResponseBody Optional<List<MeetingRoomResponse>> getMeetingRooms() {
        return meetingRoomService.getMeetingRooms();
    }

    @PostMapping
    public void createMeetingRoom(@RequestBody @Valid MeetingRoomRequest request) {
        meetingRoomService.createMeetingRoom(request);
    }

}
