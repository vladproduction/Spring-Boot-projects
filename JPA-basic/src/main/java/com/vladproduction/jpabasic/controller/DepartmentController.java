package com.vladproduction.jpabasic.controller;

import com.vladproduction.jpabasic.dto.DepartmentDto;
import com.vladproduction.jpabasic.entity.Department;
import com.vladproduction.jpabasic.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
