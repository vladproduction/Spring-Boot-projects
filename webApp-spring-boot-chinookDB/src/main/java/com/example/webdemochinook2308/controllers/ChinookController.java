package com.example.webdemochinook2308.controllers;

import com.example.webdemochinook2308.data.Artist;
import com.example.webdemochinook2308.services.AlbumService;
import com.example.webdemochinook2308.services.ArtistService;
import com.example.webdemochinook2308.services.EmployeeService;
import com.example.webdemochinook2308.services.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class ChinookController {

    private EmployeeService es;
    private ArtistService as;
    private AlbumService als;
    private InvoiceService is;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("employees", es.getEmployees());
        return "index";
    }

    @GetMapping("info")
    public String info(Model model) {
        model.addAttribute("employees", es.getInfo());
        return "info";
    }

    @GetMapping("artists")
    public String artists(Model model) {
        model.addAttribute("artists", as.getArtists());
        return "artists";
    }

    @GetMapping("filter_artists")
    public String filterArtists(Model model) {
        model.addAttribute("artists", as.getArtistsWithOneWord());
        return "artists_filtered";
    }

    @PostMapping("add_artist")
    public String addArtist(@RequestParam String artist) {
        as.addArtist(artist);
        return "redirect:/artists";
    }

    @GetMapping("delete_artist")
    public String deleteArtist(@RequestParam int id) {
        try {
            as.deleteArtist(id);
        } catch (Exception ignored) {
        }
        return "redirect:/artists";
    }

    @GetMapping("edit_artist")
    public String editArtist(@RequestParam int id, Model model) {
        Optional<Artist> a = as.findById(id);
        if (a.isPresent()) {
            model.addAttribute("artist", a.get());
            return "edit_artist";
        }
        return "redirect:/artists";
    }

    @PatchMapping("update_artist")
    public String updateArtist(@RequestParam int artist_id, @RequestParam String artist) {
        as.updateArtist(artist_id, artist);
        return "redirect:/artists";
    }

    @GetMapping("show_albums/{id}")
    public String showAlbumsByArtist(@PathVariable int id, Model model) {
        Optional<Artist> a = as.findById(id);
        if (a.isPresent()) {
            model.addAttribute("artist", a.get());
            return "albums_by_artist";
        }
        return "redirect:/artists";
    }

    @PostMapping("add_album")
    public String addAlbum(@RequestParam("a_id") int aId, @RequestParam String title) {
        als.addAlbum(aId, title);

        return "redirect:/show_albums/" + aId;
    }

    @GetMapping("/invoices")
    public String invoices(Model model) {
        model.addAttribute("invoices", is.getCheapestInvoiceList());
        return "invoices";
    }
}

/*

http://localhost:8080/show_albums/1
http://localhost:8080/delete_artist/278

http://localhost:8080/show_albums/1

http://localhost:8080/show_albums/add_album
http://localhost:8080/add_album

 */