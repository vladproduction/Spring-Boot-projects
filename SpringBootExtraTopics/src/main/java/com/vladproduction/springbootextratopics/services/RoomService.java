package com.vladproduction.springbootextratopics.services;

import com.vladproduction.springbootextratopics.entity.Room;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RoomService {

    List<Room> getAllRooms();
    Optional<Room> getRoomById(Long id);
    Room createRoom(Room room);
    Optional<Room> updateRoom(Long id, Room roomDetails);
    boolean deleteRoom(Long id);
}