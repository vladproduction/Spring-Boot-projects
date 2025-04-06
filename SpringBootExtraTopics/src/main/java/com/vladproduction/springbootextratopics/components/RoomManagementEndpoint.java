package com.vladproduction.springbootextratopics.components;

import com.vladproduction.springbootextratopics.entity.Room;
import com.vladproduction.springbootextratopics.repository.RoomRepository;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Component
@Endpoint(id = "rooms")
public class RoomManagementEndpoint {

    private final RoomRepository roomRepository;

    public RoomManagementEndpoint(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @ReadOperation
    public Map< String, Object> getRoomStatistics() {
        Map< String, Object> stats = new HashMap< >();
        stats.put("total_rooms", roomRepository.count());
        stats.put("avg_capacity", calculateAverageCapacity());
        stats.put("total_capacity", calculateTotalCapacity());
        stats.put("average_price", calculateAveragePrice());
        return stats;
    }

    @ReadOperation
    public Room getRoomDetails(@Selector Long roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new NoSuchElementException("Room not found"));
    }

    @WriteOperation
    public void updateRoomDescription(@Selector Long roomId,
                                 @Selector String description) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new NoSuchElementException("Room not found"));

        // Example of a custom write operation
        room.setDescription(description);
        roomRepository.save(room);
    }

    private double calculateAverageCapacity() {
        return roomRepository.findAll().stream()
                .mapToInt(Room::getCapacity)
                .average()
                .orElse(0.0);
    }

    private int calculateTotalCapacity() {
        return roomRepository.findAll().stream()
                .mapToInt(Room::getCapacity)
                .sum();
    }

    private BigDecimal calculateAveragePrice() {
        // Sum up all room prices; change to int if getPrice() returns int
        int total = roomRepository.findAll().stream()
                .mapToInt(Room::getPrice)
                .sum();

        long count = roomRepository.count();

        // Avoid division by zero
        return count > 0 ? BigDecimal.valueOf(total).divide(BigDecimal.valueOf(count), RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }

}
