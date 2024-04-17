package com.vladproduction.jpabasic.service;

import com.vladproduction.jpabasic.entity.Department;
import com.vladproduction.jpabasic.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by vladproduction on 15-Apr-24
 */

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    public Department saveDepartment(Department department) {
        return departmentRepository
                .save(department);
    }

    public List<Department> findAllDepartments() {
        return departmentRepository
                .findAll();
    }

    public Optional<Department> findDepartmentById(Long departmentId) {
        return departmentRepository
                .findById(departmentId);
    }


    public Optional<Department> findDepartmentByDepartmentLocation(String departmentLocation) {
        return departmentRepository
                .findDepartmentByDepartmentLocation(departmentLocation);
    }


    public Optional<Department> findByDepartmentPhone(String departmentPhone) {
        return departmentRepository
                .findByDepartmentPhone(departmentPhone);
    }

    public Optional<Department> findByDepartmentName(String departmentName) {
        return departmentRepository
                .findByDepartmentName(departmentName);
    }

}
