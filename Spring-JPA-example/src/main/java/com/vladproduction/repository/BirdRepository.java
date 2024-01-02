package com.vladproduction.repository;

import com.vladproduction.model.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Integer> {

    List<Bird> findByBird(String birdName);
}
