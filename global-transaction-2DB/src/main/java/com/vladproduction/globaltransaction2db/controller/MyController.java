package com.vladproduction.globaltransaction2db.controller;

import com.vladproduction.globaltransaction2db.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vladproduction on 09-Apr-24
 */

@RestController
@RequestMapping("/api/")
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("action")
    public void doAction(){
        myService.process();
    }

}
