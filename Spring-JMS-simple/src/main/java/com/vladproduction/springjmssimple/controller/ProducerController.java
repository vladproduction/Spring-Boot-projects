package com.vladproduction.springjmssimple.controller;

import com.vladproduction.springjmssimple.producer.MyProducer;
import jakarta.jms.JMSException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/jms")
public class ProducerController {

    private MyProducer myProducer;

    public ProducerController(MyProducer myProducer) {
        this.myProducer = myProducer;
    }

    @GetMapping("/sendWithHeader")
    public void send(@RequestParam(name = "text") String text) throws JMSException {
//        myProducer.sendWithHeader(text);
        myProducer.sendMessage(text);
    }
}
