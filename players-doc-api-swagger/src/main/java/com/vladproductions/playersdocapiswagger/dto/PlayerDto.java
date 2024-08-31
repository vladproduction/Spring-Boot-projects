package com.vladproductions.playersdocapiswagger.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "PlayerDto model information")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {

    private Long player_id;

    @Schema(description = "Player Nationality")
    @NotEmpty(message = "nationality should not be null or empty")
    private String nationality;

    @Schema(description = "Player Name")
    @NotEmpty(message = "name should not be null or empty")
    private String name;

    @Schema(description = "Player Age")
    @NotEmpty(message = "age should not be null or empty")
    private int age;

    @Schema(description = "Player email")
    @NotEmpty(message = "email should not be null or empty; unique value expected")
    private String email;

    @Schema(description = "Player salary")
    @NotEmpty(message = "salary should not be null or empty")
    private double salary;

    @Schema(description = "Player debutYear")
    @NotEmpty(message = "debutYear should not be null or empty")
    private String debutYear;

    //were added:
    @Schema(description = "The club the player belongs to")
    @NotNull(message = "club must be specified")
    private ClubDto club; // A reference to ClubDto

}
