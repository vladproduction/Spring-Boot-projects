package com.example.webdemochinook2308.repositories;

import com.example.webdemochinook2308.data.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}