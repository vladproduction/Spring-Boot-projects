package com.example.webdemochinook2308.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ArtistId", nullable = false)
    private Integer id;

    @Column(name = "Name", length = 120)
    private String name;

    @OneToMany(mappedBy = "artist")
    private Set<Album> albums = new LinkedHashSet<>();


    public Artist(String name) {
        this.name = name;
    }
}