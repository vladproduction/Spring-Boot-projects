package com.vladproduction.aop;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/send/message")
public class SimpleController {

    private final SimpleService simpleService;

    public SimpleController(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    @GetMapping(path = "/1/{msg}")
    public ResponseEntity<Void> sendMessageController(@PathVariable (value = "msg") String message) throws Exception {
        simpleService.sendMessage(message);
        return ResponseEntity.ok().build();

    }

    @GetMapping(path = "/2/{msg}")
    public ResponseEntity<Void> sendMessageController2(@PathVariable (value = "msg") String message) throws InterruptedException {
        simpleService.sendMessage(message, 100);
        return ResponseEntity.ok().build();

    }

    @GetMapping(path = "/3/{msg}")
    public ResponseEntity<Void> sendMessageController3(@PathVariable (value = "msg") String message) throws InterruptedException {
        simpleService.sendMessage(message, true);
        return ResponseEntity.ok().build();

    }
}
