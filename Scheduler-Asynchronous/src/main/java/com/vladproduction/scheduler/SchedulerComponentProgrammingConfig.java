package com.vladproduction.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;


@Component
public class SchedulerComponentProgrammingConfig {

    @Autowired
    private TaskScheduler taskScheduler;

    public void createTask(String cron, Runnable task){
        taskScheduler.schedule(task, new CronTrigger(cron));

    }

}















