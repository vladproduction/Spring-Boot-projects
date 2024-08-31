package com.vladproductions.playersdocapiswagger.mapper;

import com.vladproductions.playersdocapiswagger.dto.ClubDto;
import com.vladproductions.playersdocapiswagger.entity.Club;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoClubMapper {

    AutoClubMapper CLUB_MAPPER = Mappers.getMapper(AutoClubMapper.class);

    ClubDto mapToClubDto(Club club);

    Club mapToClub(ClubDto clubDto);

}
