package com.vladproductions.playersdocapiswagger.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clubs", uniqueConstraints = @UniqueConstraint(columnNames = "title"))
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long club_id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Country country;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private League league;

    //were added:
    // Define the relationship
    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players = new ArrayList<>();

}
