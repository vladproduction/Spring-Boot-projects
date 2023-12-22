package com.example.webdemochinook2308.repositories;

import com.example.webdemochinook2308.data.Employee;
import com.example.webdemochinook2308.data.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<EmployeeInfo> findByIdNotNull();
}