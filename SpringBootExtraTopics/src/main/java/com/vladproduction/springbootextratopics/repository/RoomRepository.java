package com.vladproduction.springbootextratopics.repository;

import com.vladproduction.springbootextratopics.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

    // Additional query methods can be defined here if needed.

}
