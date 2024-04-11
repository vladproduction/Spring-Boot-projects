package com.vladproduction.springbootmultidatasource.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vladproduction on 11-Apr-24
 */

@RestController
@RequestMapping("api/process")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @PostMapping("/saveProcess")
    public void saveProcess(){
        processService.process();
    }

}
