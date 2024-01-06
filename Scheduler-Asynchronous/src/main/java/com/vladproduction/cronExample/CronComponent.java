package com.vladproduction.cronExample;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class CronComponent {


//    @Scheduled(cron = "*/10 * * * * *")
//    public void fixedRateSchedule() throws InterruptedException {
//        String countWork = "Part work RateSchedule by thread: %s; time: %s";
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(String.format(countWork, Thread.currentThread().getName(), localDateTime));
//        TimeUnit.SECONDS.sleep(5);
//    }
}
