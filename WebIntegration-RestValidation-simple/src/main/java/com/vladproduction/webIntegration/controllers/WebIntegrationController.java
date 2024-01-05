package com.vladproduction.webIntegration.controllers;

import com.vladproduction.webIntegration.models.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/web/integration")
public class WebIntegrationController {

    @GetMapping(path = "/{clientId}/{type}")
    public ResponseEntity<Void> getURLMethod(
            @PathVariable(value = "clientId") Integer id, @PathVariable(value = "type") String type){
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Void> getRequestMethod(
            @RequestParam(value = "clientId") Integer id, @RequestParam(value = "type") String type){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> postMethod(@RequestBody Client client){

        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/postMethod2Example")
    public ResponseEntity<Void> postMethod2(@RequestBody Client client){
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> putMethod(@RequestBody Client client){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMethod(){
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<Void> patchMethod(@RequestBody Client client){
        return ResponseEntity.ok().build();
    }
}
