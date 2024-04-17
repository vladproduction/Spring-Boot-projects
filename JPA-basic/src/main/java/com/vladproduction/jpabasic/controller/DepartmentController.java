package com.vladproduction.jpabasic.controller;

import com.vladproduction.jpabasic.dto.DepartmentDto;
import com.vladproduction.jpabasic.entity.Department;
import com.vladproduction.jpabasic.mapper.DepartmentMapper;
import com.vladproduction.jpabasic.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by vladproduction on 15-Apr-24
 */

@RestController
@RequestMapping("api/jpa-basic")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/saveDepartment")
    public ResponseEntity<DepartmentDto> saveDepartment(
            @RequestBody DepartmentDto departmentDto){
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department saveDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.ok(DepartmentMapper.mapToDepartmentDto(saveDepartment));
    }

    @GetMapping("/findAllDepartments")
    public ResponseEntity<List<DepartmentDto>> findAllDepartments(){
        List<Department> allDepartments = departmentService.findAllDepartments();
        List<DepartmentDto> departmentDtoList = DepartmentMapper.mapToDepartmentsDto(allDepartments);
        return ResponseEntity.ok(departmentDtoList);
    }

    @GetMapping("/findDepartmentById/{departmentId}")
    public ResponseEntity<Optional<DepartmentDto>> findDepartmentById(
            @PathVariable Long departmentId){
        Optional<Department> departmentById = departmentService.findDepartmentById(departmentId);
        if (departmentById.isPresent()){
            Department department = departmentById.get();
            DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);
            return ResponseEntity.ok(Optional.of(departmentDto));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findDepartmentByLocation")
    public ResponseEntity<Optional<DepartmentDto>> findDepartmentByDepartmentLocation(
            @RequestParam String departmentLocation){
        Optional<Department> departmentOptional = departmentService.findDepartmentByDepartmentLocation(departmentLocation);
        if (departmentOptional.isPresent()){
            Department department = departmentOptional.get();
            DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);
            return ResponseEntity.ok(Optional.of(departmentDto));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findByDepartmentPhone")
    public ResponseEntity<Optional<DepartmentDto>> findByDepartmentPhone(
            @RequestParam String departmentPhone){
        Optional<Department> optionalDepartment = departmentService.findByDepartmentPhone(departmentPhone);
        if (optionalDepartment.isPresent()){
            Department department = optionalDepartment.get();
            DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);
            return ResponseEntity.ok(Optional.of(departmentDto));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findByDepartmentName")
    public ResponseEntity<Optional<DepartmentDto>> findByDepartmentName(
            @RequestParam String departmentName){
        Optional<Department> optionalDepartment = departmentService.findByDepartmentName(departmentName);
        if (optionalDepartment.isPresent()){
            Department department = optionalDepartment.get();
            DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);
            return ResponseEntity.ok(Optional.of(departmentDto));
        }
        return ResponseEntity.notFound().build();
    }

}
