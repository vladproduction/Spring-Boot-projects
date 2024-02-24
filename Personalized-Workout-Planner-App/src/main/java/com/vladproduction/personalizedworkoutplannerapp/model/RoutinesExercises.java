package com.vladproduction.personalizedworkoutplannerapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Getter
@Setter
@Table(name = "routines_exercises")
@ToString
public class RoutinesExercises {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routine_exercise_id", unique = true, nullable = false)
    private int routine_exercise_id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "routine_id")
    private Routines routines;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "exercise_id")
    private Exercises exercises;
    @Column(name = "sets", nullable = false)
    private int sets; //Number of sets for the exercise
    @Column(name = "reps", nullable = false)
    private int reps; //Number of repetitions per set

}
