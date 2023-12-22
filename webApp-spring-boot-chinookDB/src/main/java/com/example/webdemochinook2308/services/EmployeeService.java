package com.example.webdemochinook2308.services;

import com.example.webdemochinook2308.data.Employee;
import com.example.webdemochinook2308.data.EmployeeInfo;
import com.example.webdemochinook2308.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public List<EmployeeInfo> getInfo() {
        return employeeRepository.findByIdNotNull();
    }
}
