package com.vladproduction.personalizedworkoutplannerapp.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Getter
@Setter
@ToString
@Table(name = "exercises")
public class Exercises {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id", nullable = false, unique = true)
    private int exercise_id;
    @Column(name = "exercise_name", nullable = false, length = 45)
    private String exercise_name;
    @Column(name = "description", nullable = false, length = 245)
    private String description;
    @Column(name = "muscle_groups", nullable = false, length = 45)
    private String muscle_groups;
    @Column(name = "difficulty_exercise", nullable = false, length = 45)
    private Difficulty difficulty_exercise; //beginner, intermediate, advanced



}
