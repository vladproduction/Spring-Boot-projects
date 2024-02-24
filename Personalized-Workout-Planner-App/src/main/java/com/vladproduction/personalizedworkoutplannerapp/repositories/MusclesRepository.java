package com.vladproduction.personalizedworkoutplannerapp.repositories;

import com.vladproduction.personalizedworkoutplannerapp.model.Muscles;
import com.vladproduction.personalizedworkoutplannerapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusclesRepository extends JpaRepository<Muscles, Integer> {
}
