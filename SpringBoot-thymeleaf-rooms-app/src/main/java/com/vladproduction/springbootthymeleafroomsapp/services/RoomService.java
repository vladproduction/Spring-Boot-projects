package com.vladproduction.springbootthymeleafroomsapp.services;

import com.vladproduction.springbootthymeleafroomsapp.models.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    //mocking some data
    private static final List<Room> rooms = new ArrayList<Room>();

    static {
        for (int i = 0; i < 10; i++) {
            rooms.add(new Room(i, "Room " + i, "R " + i, "Q"));
        }
    }

    public List<Room> getAllRooms() {
        return rooms;
    }

}
