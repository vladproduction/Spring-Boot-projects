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
@ToString
@Table(name = "routines")
public class Routines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routine_id", unique = true, nullable = false)
    private int routine_id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;
    @Column(name = "routines_name", nullable = false, unique = true, length = 100)
    private String routines_name;
    @Column(name = "description", nullable = false, length = 245)
    private String description;
    @Column(name = "focus", nullable = false, length = 245)
    private String focus; //full body, cardio, strength
    @Column(name = "difficulty_routine", nullable = false)
    private Difficulty difficulty_routine;
}
