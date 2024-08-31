package com.vladproductions.playersdocapiswagger.service;

import com.vladproductions.playersdocapiswagger.dto.ClubDto;

import java.util.List;

public interface ClubService {

    ClubDto createClub(ClubDto clubDto);
    ClubDto getClubById(Long clubId);
    List<ClubDto> getAllClubs();
    ClubDto updateClub(Long clubId, String newTitle);
    void deleteClub(Long clubId);

}
