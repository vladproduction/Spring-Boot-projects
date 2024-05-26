package com.vladproduction.pagingsortingfilteringcriteriaapp.controller;

import com.vladproduction.pagingsortingfilteringcriteriaapp.model.Employee;
import com.vladproduction.pagingsortingfilteringcriteriaapp.model.EmployeePage;
import com.vladproduction.pagingsortingfilteringcriteriaapp.model.EmployeeSearchCriteria;
import com.vladproduction.pagingsortingfilteringcriteriaapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Page<Employee>> getEmployees(EmployeePage employeePage,
                                                       EmployeeSearchCriteria employeeSearchCriteria){
        return new ResponseEntity<>(employeeService.getEmployees(employeePage, employeeSearchCriteria),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
    }
}
