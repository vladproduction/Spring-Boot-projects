package com.vladproductions.playersdocapiswagger.service;


import com.vladproductions.playersdocapiswagger.dto.PlayerDto;

import java.util.List;

public interface PlayerService {

    PlayerDto createPlayer(PlayerDto playerDto);
    PlayerDto getPlayerById(Long playerId);
    List<PlayerDto> getAllPlayers();
    PlayerDto updatePlayer(Long playerId, PlayerDto playerDto);
    void deletePlayerById(Long playerId);


}
