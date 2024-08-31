package com.vladproductions.playersdocapiswagger.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "players",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long player_id;

    @Column(nullable = false)
    private String nationality;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private double salary;

    @Column(nullable = false)
    private String debutYear;

    //were added:
    // Reference to the club
    @ManyToOne
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;  // Foreign key reference to Club

}
