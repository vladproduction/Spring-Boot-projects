package com.vladproduction.logginglevelsspring.controller;

import com.vladproduction.logginglevelsspring.model.Employee;
import com.vladproduction.logginglevelsspring.model.Role;
import com.vladproduction.logginglevelsspring.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by vladproduction on 12-Mar-24
 */
@RestController
@RequestMapping("/api/logging-levels-spring")
public class EmployeeController {

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/showSalaryByRole")
    public double showSalaryByRole(@RequestBody Employee employee){

        logger.debug("###debug### ".toUpperCase() + employee.toString());

        double salary = employeeService.showSalaryByRole(employee);

        logger.info("###info ROLE### ".toUpperCase() + employee.getRole());
        logger.info("###info SALARY### ".toUpperCase() + salary);

        return salary;

    }

    @PostMapping("/showLoggerLevel")
    public String showLoggerLevel(@RequestBody String level){

//        logger.trace("===trace=== ".toUpperCase());
        logger.debug("===debug=== ".toUpperCase());
        logger.info("===info=== ".toUpperCase());
        logger.warn("===warn=== ".toUpperCase());
        logger.error("===error=== ".toUpperCase());

        return level;
    }
}
