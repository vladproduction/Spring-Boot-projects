package com.vladproduction.jpabasic.mapper;

import com.vladproduction.jpabasic.dto.DepartmentDto;
import com.vladproduction.jpabasic.entity.Department;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladproduction on 14-Apr-24
 */

public class DepartmentMapper {

    //dto --> department
    public static Department mapToDepartment(DepartmentDto departmentDto) {
        if (departmentDto == null) {
            return null;
        }
        Department department = Department.builder()
                .departmentName(departmentDto.getDepartmentName())
                .departmentPhone(departmentDto.getDepartmentPhone())
                .departmentLocation(departmentDto.getDepartmentLocation())
                .build();
        return department;

    }

    /**
     * private String departmentName;
     * private String departmentPhone;
     * private String departmentLocation;
     */

    //department --> dto
    public static DepartmentDto mapToDepartmentDto(Department department) {
        if (department == null) {
            return null;
        }
        DepartmentDto departmentDto = DepartmentDto.builder()
                .departmentName(department.getDepartmentName())
                .departmentPhone(department.getDepartmentPhone())
                .departmentLocation(department.getDepartmentLocation())
                .build();
        return departmentDto;
    }

    public static List<Department> mapToDepartments(List<DepartmentDto> departmentDtoList){
        List<Department> departments = new ArrayList<>();
        for (DepartmentDto departmentDto : departmentDtoList) {
            departments.add(mapToDepartment(departmentDto));
        }
        return departments;
    }

    public static List<DepartmentDto> mapToDepartmentsDto(List<Department> departmentList){
        List<DepartmentDto> departmentDtoList = new ArrayList<>();
        for (Department department : departmentList) {
            departmentDtoList.add(mapToDepartmentDto(department));
        }
        return departmentDtoList;
    }
}
