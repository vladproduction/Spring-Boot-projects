package com.vladproduction.javaConfig;


import com.vladproduction.javaConfig.service.SpeakerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //SpeakerService service = new SpeakerServiceImpl();

        SpeakerService service = appContext.getBean("speakerService", SpeakerService.class);
        System.out.println("\tservice = " + service);

        System.out.println(service.findAll().get(0).getFirstName());
        System.out.println(service.findAll().get(0).getSeedNum());

        SpeakerService service2 = appContext.getBean("speakerService", SpeakerService.class);
        System.out.println("\tservice2 = " + service2);
    }
}
