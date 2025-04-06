package com.vladproduction.springbootextratopics.services.impl;

import com.vladproduction.springbootextratopics.entity.Room;
import com.vladproduction.springbootextratopics.repository.RoomRepository;
import com.vladproduction.springbootextratopics.services.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Optional<Room> updateRoom(Long id, Room roomDetails) {
        return roomRepository.findById(id).map(existingRoom -> {
            existingRoom.setName(roomDetails.getName());
            existingRoom.setDescription(roomDetails.getDescription());
            existingRoom.setCapacity(roomDetails.getCapacity());
            existingRoom.setPrice(roomDetails.getPrice());

            return roomRepository.save(existingRoom);
        });
    }

    @Override
    public boolean deleteRoom(Long id) {
        try {
            if (roomRepository.existsById(id)) {
                roomRepository.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            //logging if needed
            return false;
        }
    }
}
