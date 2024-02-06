package com.vladproduction.carshearing.controller;

import com.vladproduction.carshearing.model.Owner;
import com.vladproduction.carshearing.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/car_shearing")
public class OwnerController {

    private final OwnerService ownerService;


    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/add_owner")
    public int addOwner(@RequestParam String name,
                         @RequestParam String surname,
                         @RequestParam String phone) throws SQLException {
        return ownerService.addOwner(new Owner(name, surname, phone));
    }

    @GetMapping("/owner/{id}")
    public Owner getOwnerById(@PathVariable int id) throws SQLException {
        return ownerService.getOwnerById(id);
    }

    @GetMapping("/owners")
    public List<Owner> getAllOwners() throws SQLException {
        return ownerService.getAllOwners();
    }

    @PutMapping("updateOwnerById/{id}")
    public int updateOwnerById(@PathVariable int id, @RequestBody Owner candidate) throws SQLException {
        return ownerService.updateOwnerById(id, candidate);
    }

    @DeleteMapping("/remove_owner/{id}")
    public int removeOwnerById(@PathVariable int id) throws SQLException{
        return ownerService.removeOwnerById(id);
    }



}
