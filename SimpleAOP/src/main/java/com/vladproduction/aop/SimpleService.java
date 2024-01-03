package com.vladproduction.aop;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SimpleService {

    //make method to do something:
    public void sendMessage(String message) throws Exception {

        TimeUnit.SECONDS.sleep(2);

        throw new Exception("Test message for Exception");
    }

    //and if methods is overloaded (same name but different signature)

    public void sendMessage(String message, Integer paramInteger) throws InterruptedException {

        TimeUnit.SECONDS.sleep(4);
    }

    public void sendMessage(String message, Boolean paramBoolean) throws InterruptedException {

        TimeUnit.SECONDS.sleep(6);
    }

        //testing in Postman:

//            ExecutionTime: 2001
//            ExecutionTime: 4014
//            ExecutionTime: 6010

//          vladproduction.aop.SimpleAOPComponent  : ExecutionTime: 32415; message: test
//          vladproduction.aop.SimpleAOPComponent  : ExecutionTime: 10920; message: test; param: 100
//          vladproduction.aop.SimpleAOPComponent  : ExecutionTime: 14852; message: test; param: true

}
