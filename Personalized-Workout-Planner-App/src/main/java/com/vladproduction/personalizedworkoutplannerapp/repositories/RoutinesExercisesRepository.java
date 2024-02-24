package com.vladproduction.personalizedworkoutplannerapp.repositories;

import com.vladproduction.personalizedworkoutplannerapp.model.RoutinesExercises;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutinesExercisesRepository extends JpaRepository<RoutinesExercises, Integer> {
}
