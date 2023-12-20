package com.vladproduction.example1_xml;

import java.util.logging.Logger;

public class LoggerAspect {

    private Logger logger = Logger.getLogger(LoggerAspect.class.getName());

    public void before(){
        logger.info("logger START");
    }

    public void after(){
        logger.info("logger FINISH");
    }
}
