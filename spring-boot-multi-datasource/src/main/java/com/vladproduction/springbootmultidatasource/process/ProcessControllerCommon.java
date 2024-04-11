package com.vladproduction.springbootmultidatasource.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vladproduction on 11-Apr-24
 */

@RestController
@RequestMapping("api/processCommon")
public class ProcessControllerCommon {

    @Autowired
    private ProcessServiceCommon processServiceCommon;

    @PostMapping("/doProcess")
    public void doProcess(){
        processServiceCommon.processCommon();
    }
}
