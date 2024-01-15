package com.vladproduction;

import com.vladproduction.quoters.ProfilingController;
import com.vladproduction.quoters.Quoter;
import com.vladproduction.quoters.TerminatorQuoter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {

        while (true){
            Thread.sleep(1500);
            Quoter terminatorQuoter = context.getBean(Quoter.class);
//            terminatorQuoter.sayQuote();
//            System.out.println("----------");
            terminatorQuoter.sayQuoteRepeat();

            ProfilingController profilingController = new ProfilingController();
            System.out.println("profilingControllerRes = " + profilingController.isEnabled());

        }

//        context.getBean(Quoter.class).sayQuoteRepeat();


    }
}
