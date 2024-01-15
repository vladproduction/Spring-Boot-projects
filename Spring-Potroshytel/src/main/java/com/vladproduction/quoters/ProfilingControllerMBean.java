package com.vladproduction.quoters;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Component
public interface ProfilingControllerMBean {

    //methods enabled through jmx...

    void setEnabled(boolean enabled);
}
