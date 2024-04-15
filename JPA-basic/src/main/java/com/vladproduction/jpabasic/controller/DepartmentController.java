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
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody Department department){
        return ResponseEntity.ok(departmentService.saveDepartment(department));
    }

    @GetMapping("/findAllDepartments")
    public ResponseEntity<List<DepartmentDto>> findAllDepartments(){
        return ResponseEntity.ok(departmentService.findAllDepartments());
    }

    @GetMapping("/findDepartmentById/{departmentId}")
    public ResponseEntity<Optional<DepartmentDto>> findDepartmentById(@PathVariable Long departmentId){
        Optional<DepartmentDto> departmentById = departmentService.findDepartmentById(departmentId);
        return ResponseEntity.ok(departmentById);
    }

    @GetMapping("/findByContactPhone")
    public ResponseEntity<DepartmentDto> findByContactPhone(@RequestParam String contactPhone){
        return ResponseEntity.ok(departmentService.findByContactPhone(contactPhone));
    }

    @GetMapping("/findDepartmentByName")
    public ResponseEntity<DepartmentDto> findDepartmentByName(@RequestParam String department){
        return ResponseEntity.ok(departmentService.findDepartmentByName(department));
    }
}
