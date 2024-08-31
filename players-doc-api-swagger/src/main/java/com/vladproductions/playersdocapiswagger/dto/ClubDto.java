package com.vladproductions.playersdocapiswagger.dto;

import com.vladproductions.playersdocapiswagger.entity.Country;
import com.vladproductions.playersdocapiswagger.entity.League;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "ClubDto model information")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClubDto {

    private Long club_id;

    @Schema(description = "Club title")
    @NotEmpty(message = "title should not be null or empty; unique value expected")
    private String title;

    @Schema(description = "Club country")
    @NotEmpty(message = "country should be chosen")
    private Country country;

    @Schema(description = "Club League")
    @NotEmpty(message = "league should be chosen")
    private League league;

}
