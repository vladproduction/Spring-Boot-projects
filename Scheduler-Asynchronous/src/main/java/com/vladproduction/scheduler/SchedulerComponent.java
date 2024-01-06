package com.vladproduction.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class SchedulerComponent {

//    @Scheduled(fixedRate = 1000)
//    public void fixedRateSchedule() throws InterruptedException {
//        String countWork = "Part work %s";
//        int count = 1;
//        System.out.println(String.format(countWork, count));
//        TimeUnit.SECONDS.sleep(2);
//        count++;
//    }

//    @Scheduled(fixedRate = 1000)
//    public void fixedRateSchedule() throws InterruptedException {
//        String countWork = "Part work by thread: %s";
//        System.out.println(String.format(countWork, Thread.currentThread().getName()));
//        TimeUnit.SECONDS.sleep(2);
//    }

//    @Scheduled(fixedRate = 1000)
//    public void fixedRateSchedule() throws InterruptedException {
//        String countWork = "Part work by thread: %s; time: %s";
//        long time = System.currentTimeMillis() / 1000;
//        System.out.println(String.format(countWork, Thread.currentThread().getName(), time));
//        TimeUnit.SECONDS.sleep(2);
//    }

//    @Scheduled(fixedRate = 1000)
//    public void fixedRateSchedule() throws InterruptedException {
//        String countWork = "Part work by thread: %s; time: %s";
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(String.format(countWork, Thread.currentThread().getName(), localDateTime));
//        TimeUnit.SECONDS.sleep(5);
//    }

//    @Scheduled(fixedRate = 1000)
//    public void fixedRateSchedule() throws InterruptedException {
//        String countWork = "Part work RateSchedule by thread: %s; time: %s";
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(String.format(countWork, Thread.currentThread().getName(), localDateTime));
//        TimeUnit.SECONDS.sleep(5);
//    }
//
//    @Scheduled(fixedDelay = 1000)
//    public void fixedDelaySchedule() throws InterruptedException {
//        String countWork = "Part work DelaySchedule by thread: %s; time: %s";
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(String.format(countWork, Thread.currentThread().getName(), localDateTime));
//        TimeUnit.SECONDS.sleep(5);
//    }
}















