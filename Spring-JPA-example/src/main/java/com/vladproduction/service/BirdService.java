package com.vladproduction.service;

import com.vladproduction.model.Bird;

import java.util.List;
import java.util.Optional;

public interface BirdService {

    Bird create(Bird bird);
    List<Bird> getAll();
    Optional<Bird> getById(int id);
    List<Bird> getByName(String name);
    void deleteById(int id);
    Bird update(Bird bird);

}
