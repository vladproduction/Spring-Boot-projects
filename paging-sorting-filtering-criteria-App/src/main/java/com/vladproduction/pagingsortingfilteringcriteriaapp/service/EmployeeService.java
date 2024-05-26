package com.vladproduction.pagingsortingfilteringcriteriaapp.service;

import com.vladproduction.pagingsortingfilteringcriteriaapp.model.Employee;
import com.vladproduction.pagingsortingfilteringcriteriaapp.model.EmployeePage;
import com.vladproduction.pagingsortingfilteringcriteriaapp.model.EmployeeSearchCriteria;
import com.vladproduction.pagingsortingfilteringcriteriaapp.repository.EmployeeCriteriaRepository;
import com.vladproduction.pagingsortingfilteringcriteriaapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCriteriaRepository employeeCriteriaRepository;

    public Page<Employee> getEmployees(EmployeePage employeePage,
                                       EmployeeSearchCriteria employeeSearchCriteria){
        return employeeCriteriaRepository
                .findAllWithFilters(employeePage, employeeSearchCriteria);
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository
                .save(employee);
    }

}
