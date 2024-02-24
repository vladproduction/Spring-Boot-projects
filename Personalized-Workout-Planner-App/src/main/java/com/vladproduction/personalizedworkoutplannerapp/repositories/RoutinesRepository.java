package com.vladproduction.personalizedworkoutplannerapp.repositories;

import com.vladproduction.personalizedworkoutplannerapp.model.Routines;
import com.vladproduction.personalizedworkoutplannerapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutinesRepository extends JpaRepository<Routines, Integer> {
}
