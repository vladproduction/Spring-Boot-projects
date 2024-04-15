package com.vladproduction.jpabasic.service;

import com.vladproduction.jpabasic.dto.DepartmentDto;
import com.vladproduction.jpabasic.entity.Department;
import com.vladproduction.jpabasic.mapper.DepartmentMapper;
import com.vladproduction.jpabasic.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vladproduction on 15-Apr-24
 */

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentDto saveDepartment(Department department){
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }
}
