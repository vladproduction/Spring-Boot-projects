package com.vladproductions.playersdocapiswagger.mapper;

import com.vladproductions.playersdocapiswagger.dto.PlayerDto;
import com.vladproductions.playersdocapiswagger.entity.Player;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoPlayerMapper {

    AutoPlayerMapper PLAYER_MAPPER = Mappers.getMapper(AutoPlayerMapper.class);

    PlayerDto mapToPlayerDto(Player player);

    Player mapToPlayer(PlayerDto playerDto);

}
