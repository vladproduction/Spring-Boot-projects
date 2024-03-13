package com.vladproduction.logginglevelsspring.service;

import com.vladproduction.logginglevelsspring.model.Employee;
import com.vladproduction.logginglevelsspring.model.Role;
import org.springframework.stereotype.Service;

/**
 * Created by vladproduction on 12-Mar-24
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Override
    public double showSalaryByRole(Employee employee) {
        switch (employee.getRole()) {
            case SYSTEM_ADMINISTRATOR -> {
                return 1500;
            }
            case DEVELOPER -> {
                return 2500;
            }
            case DESIGNER -> {
                return 1250;
            }
            case MANAGER -> {
                return 3850;
            }
            case CEO -> {
                return 5000;
            }
            default -> {
                throw new IllegalArgumentException("NOT RESPONDED");
            }
        }
    }

    @Override
    public String showLoggerLevel(String level) {
        if (level.equals("SA")) {
            return "SYSTEM_ADMINISTRATOR";
        }
        throw new IllegalArgumentException("NOT RESPONDED");
    }


}
