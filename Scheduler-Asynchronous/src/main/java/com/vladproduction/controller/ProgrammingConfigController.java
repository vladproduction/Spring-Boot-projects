package com.vladproduction.controller;

import com.vladproduction.scheduler.SchedulerComponentProgrammingConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/scheduler")
public class ProgrammingConfigController {

    @Autowired
    private SchedulerComponentProgrammingConfig scheduler;

    @PostMapping
    public void postScheduler(@RequestBody MyCronTask cronTask){
        scheduler.createTask(cronTask.getCron(), ()-> System.out.println(cronTask.getTask()));
    }


}
