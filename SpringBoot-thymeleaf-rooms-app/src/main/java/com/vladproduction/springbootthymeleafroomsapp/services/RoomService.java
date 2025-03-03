package com.vladproduction.springbootthymeleafroomsapp.services;

import com.vladproduction.springbootthymeleafroomsapp.data.RoomRepository;
import com.vladproduction.springbootthymeleafroomsapp.models.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

}
