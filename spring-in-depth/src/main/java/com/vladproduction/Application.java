package com.vladproduction;

import com.vladproduction.config.ApplicationConfig;
import com.vladproduction.services.OutputService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) throws InterruptedException {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        OutputService outputService = context.getBean(OutputService.class);

        for (int i = 0; i < 5; i++) {
            outputService.generateOutput();
            Thread.sleep(1000);
        }

        //08:21:48 PM Hej Tom (dev 12hours)
        //20:22:23 Hello Partner (prod 24hours)

    }
}
