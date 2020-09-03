package com.partnera.meetingOrganizer.controller;

import com.partnera.meetingOrganizer.dao.MeetingRoomDAO;
import com.partnera.meetingOrganizer.service.MeetingRoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MeetingRoomController {
    private final MeetingRoomService meetingRoomService;

    public MeetingRoomController(MeetingRoomService meetingRoomService) {
        this.meetingRoomService = meetingRoomService;
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<MeetingRoomDAO> getMeetingRoomById(@PathVariable("id") Long id) {
        return meetingRoomService.getMeetingRoomById(id);
    }

    @PostMapping("/create")
    public void createMeetingRoom(@RequestBody MeetingRoomDAO meetingRoomDAO) {
        meetingRoomService.createMeetingRoom(meetingRoomDAO);
    }

}
