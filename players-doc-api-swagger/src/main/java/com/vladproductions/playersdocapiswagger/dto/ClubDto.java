package com.vladproductions.playersdocapiswagger.dto;

import com.vladproductions.playersdocapiswagger.entity.Country;
import com.vladproductions.playersdocapiswagger.entity.League;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "club_id should not be null")
    @Min(value = 1, message = "id; should be min: 1")
    private Long club_id;

    @Schema(description = "Club title")
    @NotEmpty(message = "title should not be null or empty; unique value expected")
    private String title;

    @Schema(description = "Club country")
    @NotNull(message = "country should be chosen")
    private Country country;

    @Schema(description = "Club League")
    @NotNull(message = "league should be chosen")
    private League league;

    /*NOTE:
    If Country is an enum (or any object), you should use @NotNull instead of @NotEmpty.
    This annotation will ensure that the country field is not null and has a defined value from the Country enum.*/

}
