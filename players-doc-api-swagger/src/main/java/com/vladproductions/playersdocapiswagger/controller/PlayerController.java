package com.vladproductions.playersdocapiswagger.controller;

import com.vladproductions.playersdocapiswagger.dto.PlayerDto;
import com.vladproductions.playersdocapiswagger.service.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(
        name = "CRUD REST APIs: Player Resource",
        description = "CRUD REST API: Create Player, Get Player, Get All Players, Update Player, Delete Player"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/players")
public class PlayerController {

    private PlayerService playerService;

    @Operation(
            summary = "[POST]: create Player REST API",
            description = "create Player REST API is used for save player in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    // [POST]: create Player REST API
    @PostMapping
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody PlayerDto playerDto){
        PlayerDto player = playerService.createPlayer(playerDto);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }

    @Operation(
            summary = "[GET]: get Player REST API",
            description = "get Player by ID REST API is used for search player by id in a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    // [GET]: getPlayerById REST API
    @GetMapping("/{playerId}")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable Long playerId){
        PlayerDto player = playerService.getPlayerById(playerId);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @Operation(
            summary = "[GET]: get Players REST API",
            description = "get Players REST API is used for search all players from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    // [GET]: getAllPlayers REST API
    @GetMapping
    public ResponseEntity<List<PlayerDto>> getAllPlayers(){
        List<PlayerDto> allPlayers = playerService.getAllPlayers();
        return new ResponseEntity<>(allPlayers, HttpStatus.OK);
    }

    @Operation(
            summary = "[PATCH]: update Player REST API",
            description = "update Player REST API is used for search player by id and" +
                    "update by PATCH-like behavior where not all fields need to be updated"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    // [PATCH]: updatePlayer REST API
    @PatchMapping("/{playerId}")
    public ResponseEntity<PlayerDto> updatePlayer(@PathVariable Long playerId, @RequestBody PlayerDto playerDto){
        PlayerDto updatePlayer = playerService.updatePlayer(playerId, playerDto);
        return new ResponseEntity<>(updatePlayer, HttpStatus.CREATED);
    }

    @Operation(
            summary = "[DELETE]: delete Player REST API",
            description = "delete Player REST API is used for search by id and remove player entity from database"
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 NO_CONTENT"
    )
    // [DELETE]: deletePlayerById  REST API
    @DeleteMapping("/{playerId}")
    public ResponseEntity<Void> deletePlayerById(@PathVariable Long playerId){
        playerService.deletePlayerById(playerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
