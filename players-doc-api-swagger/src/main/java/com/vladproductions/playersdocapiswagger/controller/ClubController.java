package com.vladproductions.playersdocapiswagger.controller;

import com.vladproductions.playersdocapiswagger.dto.ClubDto;
import com.vladproductions.playersdocapiswagger.service.ClubService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs: Club Resource",
        description = "CRUD REST API: Create Club, Get Club, Get All Clubs, Update Club, Delete Club"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/clubs")
@Validated
public class ClubController {

    private ClubService clubService;

    @Operation(
            summary = "[POST]: create Club REST API",
            description = "create Club REST API is used for save club in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    // [POST]: createClub REST API
    @PostMapping
    public ResponseEntity<ClubDto> createClub(@RequestBody @Valid ClubDto clubDto){
        ClubDto club = clubService.createClub(clubDto);
        return new ResponseEntity<>(club, HttpStatus.CREATED);
    }

    @Operation(
            summary = "[GET]: get Club REST API",
            description = "get Club by ID REST API is used for search club in a database by id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    // [GET]: getById Club REST API
    @GetMapping("/{clubId}")
    public ResponseEntity<ClubDto> getClubById(@PathVariable Long clubId){
        ClubDto club = clubService.getClubById(clubId);
        return new ResponseEntity<>(club, HttpStatus.OK);
    }

    @Operation(
            summary = "[GET]: get Clubs REST API",
            description = "get All Clubs REST API is used for get all clubs from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    // [GET]: getAllClubs  REST API
    @GetMapping
    public ResponseEntity<List<ClubDto>> getAllClubs(){
        return new ResponseEntity<>(clubService.getAllClubs(), HttpStatus.OK);
    }

    @Operation(
            summary = "[PUT]: update Club REST API",
            description = "update Club REST API is used for change title for the club"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    // [PUT]: updateClub  REST API
    @PutMapping("/{clubId}")
    public ResponseEntity<ClubDto> updateClub(@PathVariable Long clubId, @RequestBody String newTitle) {
        ClubDto updatedClub = clubService.updateClub(clubId, newTitle);
        return new ResponseEntity<>(updatedClub, HttpStatus.CREATED);
    }

    @Operation(
            summary = "[DELETE]: delete Club REST API",
            description = "delete Club REST API is used for search by id and remove club entity from database"
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 NO_CONTENT"
    )
    // [DELETE]: deleteClub  REST API
    @DeleteMapping("/{clubId}")
    public ResponseEntity<Void> deleteClub(@PathVariable Long clubId){
        clubService.deleteClub(clubId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
