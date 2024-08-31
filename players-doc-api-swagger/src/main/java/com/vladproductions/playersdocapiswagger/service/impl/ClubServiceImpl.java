package com.vladproductions.playersdocapiswagger.service.impl;

import com.vladproductions.playersdocapiswagger.dto.ClubDto;
import com.vladproductions.playersdocapiswagger.entity.Club;
import com.vladproductions.playersdocapiswagger.exception.ClubAlreadyExistException;
import com.vladproductions.playersdocapiswagger.exception.ClubDoesNotExistException;
import com.vladproductions.playersdocapiswagger.mapper.AutoClubMapper;
import com.vladproductions.playersdocapiswagger.repository.ClubRepository;
import com.vladproductions.playersdocapiswagger.service.ClubService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.vladproductions.playersdocapiswagger.mapper.AutoClubMapper.*;

@Service
@AllArgsConstructor
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;

    @Override
    public ClubDto createClub(ClubDto clubDto) {
        Optional<Club> optionalClub = clubRepository.findByTitle(clubDto.getTitle());
        if(optionalClub.isPresent()){
            throw new ClubAlreadyExistException("Club already exist, use another title");
        }
        Club club = CLUB_MAPPER.mapToClub(clubDto);
        Club saved = clubRepository.save(club);
        return CLUB_MAPPER.mapToClubDto(saved);
    }

    @Override
    public ClubDto getClubById(Long clubId) {
        Optional<Club> optionalClub = clubRepository.findById(clubId);
        if(optionalClub.isEmpty()){
            throw new ClubDoesNotExistException("Club not exist, use another id; current id is: " + clubId);
        }
        Club club = optionalClub.get();
        return CLUB_MAPPER.mapToClubDto(club);
    }

    @Override
    public List<ClubDto> getAllClubs() {
        List<Club> clubRepositoryAll = clubRepository.findAll();
        List<ClubDto> clubsDtoList = new ArrayList<>();
        for (Club club : clubRepositoryAll) {
            clubsDtoList.add(CLUB_MAPPER.mapToClubDto(club));
        }
        return clubsDtoList;
    }

    //need to think
    //assume we can think that club could change title (in some circumstances)
    @Override
    public ClubDto updateClub(Long clubId, String newTitle) {
        Optional<Club> optionalClub = clubRepository.findById(clubId);
        if(optionalClub.isEmpty()){
            throw new ClubDoesNotExistException("Club not exist, use another id; current id is: " + clubId);
        }
        Club club = optionalClub.get();
        club.setTitle(newTitle);
        Club saved = clubRepository.save(club);
        return CLUB_MAPPER.mapToClubDto(saved);
    }

    //need to think the case when club is deleted, all associated players go to 'free-agent-club'
    @Override
    public void deleteClub(Long clubId) {
        Optional<Club> optionalClub = clubRepository.findById(clubId);
        if(optionalClub.isEmpty()){
            throw new ClubDoesNotExistException("Club not exist, use another id; current id is: " + clubId);
        }
        clubRepository.deleteById(clubId);
    }
}
