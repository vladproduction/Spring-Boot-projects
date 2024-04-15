package com.vladproduction.jpabasic.service;

import com.vladproduction.jpabasic.dto.DepartmentDto;
import com.vladproduction.jpabasic.dto.StudentDto;
import com.vladproduction.jpabasic.entity.Department;
import com.vladproduction.jpabasic.entity.Student;
import com.vladproduction.jpabasic.mapper.DepartmentMapper;
import com.vladproduction.jpabasic.mapper.StudentMapper;
import com.vladproduction.jpabasic.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<DepartmentDto> findAllDepartments(){
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDto> departmentDtoList = new ArrayList<>();
        for (Department department: departments) {
            departmentDtoList.add(DepartmentMapper.mapToDepartmentDto(department));
        }
        return departmentDtoList;
    }

    public Optional<DepartmentDto> findDepartmentById(Long departmentId){
        Optional<Department> departmentOptional = departmentRepository.findById(departmentId);
        if(departmentOptional.isPresent()){
            Department department = departmentOptional.get();
            DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);
            return Optional.of(departmentDto);
        }
        return Optional.empty();
    }

    public DepartmentDto findByContactPhone(String contactPhone){

        return departmentRepository.findByContactPhone(contactPhone);
    }


    public DepartmentDto findDepartmentByName(String department){

        return departmentRepository.findByName(department);
    }
}
