package com.vladproduction.personalizedworkoutplannerapp.repositories;

import com.vladproduction.personalizedworkoutplannerapp.model.Exercises;
import com.vladproduction.personalizedworkoutplannerapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercisesRepository extends JpaRepository<Exercises, Integer> {
}
