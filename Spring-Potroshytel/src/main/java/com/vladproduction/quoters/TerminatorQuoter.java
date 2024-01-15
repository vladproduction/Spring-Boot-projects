package com.vladproduction.quoters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service("terminatorQuoter")
@Profiling
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    @Value("${terminator.quote.message}")
    private String message;

    @PostConstruct
    public void init(){
        System.out.println("\tPhase #2: (init())");
        System.out.println("\trepeat = " + repeat);
    }

    public TerminatorQuoter() {
        System.out.println("\tPhase #1: (TerminatorQuoter())");
    }

    @Override
//    @PostProxy
    public void sayQuoteRepeat() {
        System.out.println("\tPhase #3: @PostProxy");
        System.out.println("\tsayQuoteRepeat():");
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }

//    @Override
//    @PostConstruct
//    public String sayQuote() {
//        System.out.println("\tsayQuote(): " + message);
//        return message;
//    }


}
