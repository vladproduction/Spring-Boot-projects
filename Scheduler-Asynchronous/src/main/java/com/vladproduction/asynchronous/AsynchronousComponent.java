package com.vladproduction.asynchronous;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class AsynchronousComponent {

    @Async
    public void doAsync(){
        System.out.println("doAsync-Start");
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("doAsync-Finish");
    }


    public void doSync(){
        System.out.println("doSync-Start");
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("doSync-Finish");
    }

//    @Async
//    @Scheduled(fixedRate = 1000)
//    public void fixedRateSchedule() throws InterruptedException {
//        String countWork = "Part work RateSchedule by thread: %s; time: %s";
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(String.format(countWork, Thread.currentThread().getName(), localDateTime));
//        TimeUnit.SECONDS.sleep(5);
//    }
//
//    @Async
//    @Scheduled(fixedDelay = 1000)
//    public void fixedDelaySchedule() throws InterruptedException {
//        String countWork = "Part work DelaySchedule by thread: %s; time: %s";
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(String.format(countWork, Thread.currentThread().getName(), localDateTime));
//        TimeUnit.SECONDS.sleep(5);
//    }

//    @Async
//    @Scheduled(fixedRate = 1000, initialDelay = 5000)
//    public void fixedRateSchedule() throws InterruptedException {
//        String countWork = "Part work RateSchedule by thread: %s; time: %s";
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(String.format(countWork, Thread.currentThread().getName(), localDateTime));
//        TimeUnit.SECONDS.sleep(5);
//    }

//    @Async
//    @Scheduled(fixedDelay = 1000, initialDelay = 5000)
//    public void fixedDelaySchedule() throws InterruptedException {
//        String countWork = "Part work DelaySchedule by thread: %s; time: %s";
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(String.format(countWork, Thread.currentThread().getName(), localDateTime));
//        TimeUnit.SECONDS.sleep(5);
//    }
}
