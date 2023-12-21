package com.vladproduction;

import com.vladproduction.config.MyConfig;
import com.vladproduction.processor.Processor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);

        Processor processor = ctx.getBean(Processor.class);
        String string = processor.process();
        System.out.println("string = " + string);

        ctx.close();

    }
}


