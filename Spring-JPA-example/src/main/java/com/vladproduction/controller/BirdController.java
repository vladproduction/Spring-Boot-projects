package com.vladproduction.controller;

import com.vladproduction.model.Bird;
import com.vladproduction.service.BirdService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/birds")
public class BirdController {

    private final BirdService birdService;

    public BirdController(BirdService birdService) {
        this.birdService = birdService;
    }


    //http://localhost:8080/api/birds
   // @GetMapping(value = "/getall", produces = APPLICATION_JSON_VALUE)
    @GetMapping
    public List<Bird> getAllBirds(){
        return birdService.getAll();
    }

    //http://localhost:8080/api/birds/id
    @GetMapping(value = "/{id}")
    public Optional<Bird> getBirdById(@PathVariable int id){
        return birdService.getById(id);
    }

    //http://localhost:8080/api/birds/name/birdName
    @GetMapping(value = "/name/{birdName}")
    public List<Bird> getBirdsByName(@PathVariable String birdName){
        return birdService.getByName(birdName);
    }

    //version#1
//    //http://localhost:8080/api/birds
//    @PostMapping
//    public Bird saveBird(@RequestBody Bird bird, HttpServletResponse response){
//        response.setStatus(201);
//        return birdService.create(bird);
//    }

    //version#2
    //http://localhost:8080/api/birds
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bird saveBird(@RequestBody Bird bird){

        return birdService.create(bird);
    }

    //http://localhost:8080/api/birds
    @PutMapping
    public Bird updateBird(@RequestBody Bird bird){
        return birdService.update(bird);
    }

    //http://localhost:8080/api/birds/id
    @DeleteMapping(value = "/{id}")
    public void deleteBirdById(@PathVariable int id){
        birdService.deleteById(id);
    }
}
