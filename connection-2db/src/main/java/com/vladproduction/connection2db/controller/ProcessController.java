package com.vladproduction.connection2db.controller;

import com.vladproduction.connection2db.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vladproduction on 10-Apr-24
 */

@RestController
@RequestMapping("/api/connection-2db")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @PostMapping("/doProcess")
    public void doProcess(){
        processService.process();
    }
}
