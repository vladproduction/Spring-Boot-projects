package com.vladproduction.logginglevelsspring.service;

import com.vladproduction.logginglevelsspring.model.Employee;
import com.vladproduction.logginglevelsspring.model.Role;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by vladproduction on 12-Mar-24
 */

public interface EmployeeService {

    double showSalaryByRole(Employee employee);
    String showLoggerLevel(String level);


}
