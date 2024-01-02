package com.vladproduction.service;

import com.vladproduction.model.Bird;
import com.vladproduction.repository.BirdRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BirdServiceImpl implements BirdService {

    private final BirdRepository birdRepository;

    public BirdServiceImpl(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @Override
    public Bird create(Bird bird) {
        bird.setId(null);
        return birdRepository.save(bird);
    }

    @Override
    public List<Bird> getAll() {
        return birdRepository.findAll();
    }

    @Override
    public Optional<Bird> getById(int id) {
        return birdRepository.findById(id);
    }

    @Override
    public List<Bird> getByName(String name) {
        return birdRepository.findByBird(name);
    }

    @Override
    public void deleteById(int id) {
        birdRepository.deleteById(id);

    }

    @Override
    public Bird update(Bird bird) {
        if(bird.getId() == null){
            throw new IllegalStateException("Bird has id = null");
        }
        return birdRepository.save(bird);
    }
}
