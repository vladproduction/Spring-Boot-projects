package com.example.webdemochinook2308.repositories;

import com.example.webdemochinook2308.data.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    List<Artist> findByNameNotContains(String str);

}