package com.vladproduction.springbootextratopics.controllers;

import com.vladproduction.springbootextratopics.entity.Room;
import com.vladproduction.springbootextratopics.services.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public String getAllRooms(Model model) {
        List<Room> rooms = roomService.getAllRooms();
        model.addAttribute("rooms", rooms);
        return "rooms";
    }

    @GetMapping("/{id}")
    public String getRoomById(@PathVariable Long id, Model model) {
        Optional<Room> room = roomService.getRoomById(id);
        if (room.isPresent()) {
            model.addAttribute("room", room.get());
            return "room-details";
        } else {
            return "redirect:/rooms";
        }
    }

    @GetMapping("/create")
    public String showCreateRoomForm(Model model) {
        model.addAttribute("room", new Room());
        return "create-room";
    }

    @PostMapping
    public String createRoom(@ModelAttribute Room room, RedirectAttributes redirectAttributes) {
        roomService.createRoom(room);
        redirectAttributes.addFlashAttribute("successMessage", "Room created successfully!");
        return "redirect:/rooms";
    }

    @GetMapping("/update/{id}")
    public String showUpdateRoomForm(@PathVariable Long id, Model model) {
        Optional<Room> room = roomService.getRoomById(id);
        if (room.isPresent()) {
            model.addAttribute("room", room.get());
            return "update-room";
        } else {
            return "redirect:/rooms";
        }
    }

    @PostMapping("/update/{id}")
    public String updateRoom(@PathVariable Long id, @ModelAttribute Room roomDetails, RedirectAttributes redirectAttributes) {
        roomService.updateRoom(id, roomDetails);
        redirectAttributes.addFlashAttribute("successMessage", "Room updated successfully!");
        return "redirect:/rooms";
    }

    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        boolean deleted = roomService.deleteRoom(id);
        if (deleted) {
            redirectAttributes.addFlashAttribute("successMessage", "Room deleted successfully!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Room could not be deleted.");
        }
        return "redirect:/rooms";
    }

    @GetMapping("/search")
    public String searchRoomById(@RequestParam Long id, Model model) {
        Optional<Room> room = roomService.getRoomById(id);
        if (room.isPresent()) {
            model.addAttribute("rooms", List.of(room.get()));
        } else {
            model.addAttribute("message", "Room not found!");
        }
        return "rooms";
    }

}
