package com.vladproduction.springbootthymeleafroomsapp.data;

import com.vladproduction.springbootthymeleafroomsapp.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
