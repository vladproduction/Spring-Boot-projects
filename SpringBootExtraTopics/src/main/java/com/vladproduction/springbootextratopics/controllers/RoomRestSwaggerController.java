package com.vladproduction.springbootextratopics.controllers;

import com.vladproduction.springbootextratopics.entity.Room;
import com.vladproduction.springbootextratopics.repository.RoomRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomRestSwaggerController {

    //http://localhost:8080/swagger-ui.html

    private final RoomRepository roomRepository;

    public RoomRestSwaggerController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Operation(summary = "Retrieve all rooms", description = "Fetches a list of all rooms available.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful retrieval of rooms."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    @GetMapping
    public List<Room> getAllRooms() {
        return roomRepository.findAll(); // Fetch all rooms
    }

    @Operation(summary = "Retrieve a room by ID", description = "Fetches a room using its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Room found."),
            @ApiResponse(responseCode = "404", description = "Room not found.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@Parameter(description = "ID of the room to be retrieved") @PathVariable Long id) {
        return roomRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // Get room by ID
    }

    @Operation(summary = "Create a new room", description = "Adds a new room to the list.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Room created successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input.")
    })
    @PostMapping
    public Room createRoom(@Parameter(description = "Room object to be created") @RequestBody Room room) {
        return roomRepository.save(room); // Create a new room
    }

    @Operation(summary = "Update an existing room", description = "Updates the details of a room.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Room updated successfully."),
            @ApiResponse(responseCode = "404", description = "Room not found.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(
            @Parameter(description = "ID of the room to be updated") @PathVariable Long id,
            @Parameter(description = "Updated room details") @RequestBody Room roomDetails) {
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

    @Operation(summary = "Delete a room", description = "Removes a room from the list.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Room deleted successfully."),
            @ApiResponse(responseCode = "404", description = "Room not found.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRoom(@Parameter(description = "ID of the room to be deleted") @PathVariable Long id) {
        return roomRepository.findById(id)
                .map(room -> {
                    roomRepository.delete(room);
                    return ResponseEntity.ok().build(); // Delete room
                })
                .orElse(ResponseEntity.notFound().build()); // Room not found
    }

}
