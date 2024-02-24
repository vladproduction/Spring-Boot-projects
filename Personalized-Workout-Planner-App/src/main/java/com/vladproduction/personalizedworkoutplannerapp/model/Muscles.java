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
@Table(name = "muscles")
public class Muscles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "muscle_id", unique = true, nullable = false)
    private int muscle_id;
    @Column(name = "muscle_name", nullable = false, unique = true, length = 100)
    private String muscle_name;
}
