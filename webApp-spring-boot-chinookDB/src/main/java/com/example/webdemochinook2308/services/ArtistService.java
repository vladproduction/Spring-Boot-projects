package com.example.webdemochinook2308.services;

import com.example.webdemochinook2308.data.Artist;
import com.example.webdemochinook2308.repositories.ArtistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;

    public List<Artist> getArtists() {
        return artistRepository.findAll();
    }

    public void addArtist(String artist) {
        artistRepository.save(new Artist(artist));
    }

    public void deleteArtist(int id) {

        artistRepository.deleteById(id);
    }

    public Optional<Artist> findById(int id) {
        return artistRepository.findById(id);
    }

    public void updateArtist(int artistId, String name) {
        Optional<Artist> artist = artistRepository.findById(artistId);
        artist.ifPresent(a -> {
            a.setName(name);
            artistRepository.save(a);
        });
    }

    public List<Artist> getArtistsWithOneWord() {
        return artistRepository.findByNameNotContains(" ");
    }
}
