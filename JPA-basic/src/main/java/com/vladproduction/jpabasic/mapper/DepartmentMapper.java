package com.vladproduction.jpabasic.mapper;

import com.vladproduction.jpabasic.dto.DepartmentDto;
import com.vladproduction.jpabasic.entity.Department;

/**
 * Created by vladproduction on 14-Apr-24
 */

public class DepartmentMapper {

    //dto --> department
    public static Department mapToDepartment(DepartmentDto departmentDto){
        Department department = Department.builder()
                .name(departmentDto.getName())
                .contactPhone(departmentDto.getContactPhone())
                .location(departmentDto.getLocation())
                .build();
        return department;

    }


    //department --> dto
    public static DepartmentDto mapToDepartmentDto(Department department){
        DepartmentDto departmentDto = DepartmentDto.builder()
                .name(department.getName())
                .contactPhone(department.getContactPhone())
                .location(department.getLocation())
                .build();
        return departmentDto;
    }
}
