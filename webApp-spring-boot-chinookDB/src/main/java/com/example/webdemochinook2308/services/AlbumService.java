package com.example.webdemochinook2308.services;

import com.example.webdemochinook2308.data.Album;
import com.example.webdemochinook2308.data.Artist;
import com.example.webdemochinook2308.repositories.AlbumRepository;
import com.example.webdemochinook2308.repositories.ArtistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AlbumService {
    private final AlbumRepository albumRepository;

    private final ArtistRepository artistRepository;


    public void addAlbum(int aId, String title) {
        Optional<Artist> optionalArtist = artistRepository.findById(aId);
        optionalArtist.ifPresent(artist -> {
            Album album = new Album();
            album.setTitle(title);
            album.setArtist(artist);
            albumRepository.save(album);
        });
    }
}
