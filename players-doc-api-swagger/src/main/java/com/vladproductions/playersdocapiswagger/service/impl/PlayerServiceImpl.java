package com.vladproductions.playersdocapiswagger.service.impl;

import com.vladproductions.playersdocapiswagger.dto.PlayerDto;
import com.vladproductions.playersdocapiswagger.entity.Club;
import com.vladproductions.playersdocapiswagger.entity.Player;
import com.vladproductions.playersdocapiswagger.exception.ClubDoesNotExistException;
import com.vladproductions.playersdocapiswagger.exception.EmailAlreadyExistException;
import com.vladproductions.playersdocapiswagger.exception.PlayerNotExistException;
import com.vladproductions.playersdocapiswagger.mapper.AutoPlayerMapper;
import com.vladproductions.playersdocapiswagger.repository.ClubRepository;
import com.vladproductions.playersdocapiswagger.repository.PlayerRepository;
import com.vladproductions.playersdocapiswagger.service.PlayerService;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.vladproductions.playersdocapiswagger.mapper.AutoPlayerMapper.*;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {


    private PlayerRepository playerRepository;
    private ClubRepository clubRepository;

    @Override
    public PlayerDto createPlayer(PlayerDto playerDto) {
        Optional<Player> playerOptional = playerRepository.findByEmail(playerDto.getEmail());
        if(playerOptional.isPresent()){
            throw new EmailAlreadyExistException("Email already exist, and you trying to save existing player.");
        }
        Player player = PLAYER_MAPPER.mapToPlayer(playerDto);
        Player saved = playerRepository.save(player);
        return PLAYER_MAPPER.mapToPlayerDto(saved);
    }

    @Override
    public PlayerDto getPlayerById(Long playerId) {
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        if(optionalPlayer.isEmpty()){
            throw new PlayerNotExistException("Player not exist; use another id to search; current id is: " + playerId);
        }
        Player player = optionalPlayer.get();
        return PLAYER_MAPPER.mapToPlayerDto(player);
    }

    @Override
    public List<PlayerDto> getAllPlayers() {
        List<Player> playerList = playerRepository.findAll();
        List<PlayerDto> allPlayersDto = new ArrayList<>();
        for (Player player : playerList) {
            allPlayersDto.add(PLAYER_MAPPER.mapToPlayerDto(player));
        }
        return allPlayersDto;
    }

    @Override
    public PlayerDto updatePlayer(Long playerId, PlayerDto playerDto) {
        // Fetch the existing player by ID:
        Player existingPlayer = playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotExistException("Player not found with ID: " + playerId));
        // Update only the fields that are provided in playerDto:
        if (playerDto.getNationality() != null) {
            existingPlayer.setNationality(playerDto.getNationality());
        }
        if (playerDto.getName() != null) {
            existingPlayer.setName(playerDto.getName());
        }
        if (playerDto.getAge() != 0) {
            existingPlayer.setAge(playerDto.getAge());
        }
        if (playerDto.getEmail() != null) {
            existingPlayer.setEmail(playerDto.getEmail());
        }
        if (playerDto.getSalary() != 0) {
            existingPlayer.setSalary(playerDto.getSalary());
        }
        if (playerDto.getDebutYear() != null) {
            existingPlayer.setDebutYear(playerDto.getDebutYear());
        }

        // For the club, if we want to set it as well, we can do as follows:
        if (playerDto.getClub() != null && playerDto.getClub().getClub_id() != null) {
            Club club = clubRepository.findById(playerDto.getClub().getClub_id())
                    .orElseThrow(() -> new ClubDoesNotExistException(
                            "Club not found with ID: " + playerDto.getClub().getClub_id()));
            existingPlayer.setClub(club);
        }

        // Save the updated player to the repository
        playerRepository.save(existingPlayer);

        return PLAYER_MAPPER.mapToPlayerDto(existingPlayer);
    }

    @Override
    public void deletePlayerById(Long playerId) {
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        if(optionalPlayer.isEmpty()){
            throw new PlayerNotExistException("Player not found with ID: " + playerId);
        }
        playerRepository.deleteById(playerId);
    }
}
