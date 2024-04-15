package com.vladproduction.jpabasic.controller;

import com.vladproduction.jpabasic.dto.StudentDto;
import com.vladproduction.jpabasic.entity.Student;
import com.vladproduction.jpabasic.mapper.StudentMapper;
import com.vladproduction.jpabasic.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by vladproduction on 12-Apr-24
 */

@RestController
@RequestMapping("api/jpa-basic")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //=====Save Student REST API=====
    @PostMapping("/saveStudent")
    public ResponseEntity<StudentDto> saveStudent(@RequestBody Student student){
        return ResponseEntity.ok(studentService.saveStudent(student)); //expected status: 200
    }
//    @PostMapping("/saveStudent")
//    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto){
//        return new ResponseEntity<>(studentService.saveStudent(studentDto), HttpStatus.CREATED); //expected status: 201
//    }

    //=====FindAll Students REST API=====
    @GetMapping("/findAllStudents")
    public ResponseEntity<List<StudentDto>> findAllStudents(){
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    //=====Find StudentById REST API=====
    @GetMapping("/findStudentById/{studentId}")
    public ResponseEntity<Optional<StudentDto>> findStudentById(@PathVariable Long studentId){
        Optional<StudentDto> studentById = studentService.findStudentById(studentId);
        return ResponseEntity.ok(studentById);
    }

    //=====Find StudentByEmail REST API=====
    @GetMapping("/findStudentByEmail")
    public ResponseEntity<StudentDto> findStudentByEmail(@RequestParam String email){
        return ResponseEntity.ok(studentService.findStudentByEmail(email));
    }



}
