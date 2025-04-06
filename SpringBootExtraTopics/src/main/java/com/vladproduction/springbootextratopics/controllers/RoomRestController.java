package com.vladproduction.springbootextratopics.controllers;

import com.vladproduction.springbootextratopics.entity.Room;
import com.vladproduction.springbootextratopics.repository.RoomRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomRestController {

    //service layer omitted for the RoomRestController

    private final RoomRepository roomRepository;

    public RoomRestController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomRepository.findAll(); // Fetch all rooms
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        return roomRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // Get room by ID
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomRepository.save(room); // Create a new room
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room roomDetails) {
        return roomRepository.findById(id)
                .map(room -> {
                    room.setName(roomDetails.getName());
                    room.setDescription(roomDetails.getDescription());
                    room.setCapacity(roomDetails.getCapacity());
                    room.setPrice(roomDetails.getPrice());
                    Room updatedRoom = roomRepository.save(room);
                    return ResponseEntity.ok(updatedRoom);
                })
                .orElse(ResponseEntity.notFound().build()); // Update an existing room
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRoom(@PathVariable Long id) {
        return roomRepository.findById(id)
                .map(room -> {
                    roomRepository.delete(room);
                    return ResponseEntity.ok().build(); // Delete room
                })
                .orElse(ResponseEntity.notFound().build()); // Room not found
    }
}

