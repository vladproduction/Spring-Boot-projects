package com.vladproduction.springbootactuatorexample.endpoints;

import org.apache.tomcat.util.net.AbstractEndpoint;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

/**
 * Created by vladproduction on 11-Mar-24
 */

//@Component
@Controller
@Endpoint(id = "custom")
public class MyCustomEndpoint {

    @ReadOperation  // For GET requests
    @GetMapping("/custom")
    public String getCustomData(){
        String string = "Today: " + new Date();
        return string;
    }


    @WriteOperation // For POST requests
    public void updateCustomData(String newData) {
        // Implement logic to update custom data based on newData
        System.out.println("Custom data updated: " + newData + "and time is: " + new Date());
    }

}
