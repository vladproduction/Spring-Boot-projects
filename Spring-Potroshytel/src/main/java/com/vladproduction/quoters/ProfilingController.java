package com.vladproduction.quoters;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ProfilingController implements ProfilingControllerMBean{

    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
