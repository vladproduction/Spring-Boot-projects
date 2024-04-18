package com.vladproduction.jpabasic.controller;

import com.vladproduction.jpabasic.dto.StudentDto;
import com.vladproduction.jpabasic.entity.Student;
import com.vladproduction.jpabasic.mapper.StudentMapper;
import com.vladproduction.jpabasic.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/saveStudent")
    public ResponseEntity<StudentDto> saveStudent(
            @RequestBody StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student saveStudent = studentService.saveStudent(student);
        StudentDto saveStudentDto = StudentMapper.mapToStudentDto(saveStudent);
        return ResponseEntity.ok(saveStudentDto); //expected status: 200
    }

    @GetMapping("/findAllStudents")
    public ResponseEntity<List<StudentDto>> findAllStudents() {
        List<Student> students = studentService.findAllStudents();
        List<StudentDto> studentDtoList = StudentMapper.mapToStudentsDto(students);
        return ResponseEntity.ok(studentDtoList);
    }

    @GetMapping("/findStudentById/{studentId}")
    public ResponseEntity<Optional<StudentDto>> findStudentById(
            @PathVariable Long studentId) {
        Optional<Student> studentById = studentService.findStudentById(studentId);
        if (studentById.isPresent()) {
            Student student = studentById.get();
            StudentDto studentDto = StudentMapper.mapToStudentDto(student);
            return ResponseEntity.ok(Optional.of(studentDto));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findStudentByEmail")
    public ResponseEntity<Optional<StudentDto>> findStudentByStudentEmail(
            @RequestParam String studentEmail) {
        Optional<Student> studentByEmail = studentService.findStudentByStudentEmail(studentEmail);
        if (studentByEmail.isPresent()) {
            Student student = studentByEmail.get();
            StudentDto studentDto = StudentMapper.mapToStudentDto(student);
            return ResponseEntity.ok(Optional.of(studentDto));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findStudentByLastName")
    public ResponseEntity<Optional<StudentDto>> findStudentByLastName(
            @RequestParam String lastName) {
        Optional<Student> studentByLastName = studentService.findStudentByLastName(lastName);
        if (studentByLastName.isPresent()) {
            Student student = studentByLastName.get();
            StudentDto studentDto = StudentMapper.mapToStudentDto(student);
            return ResponseEntity.ok(Optional.of(studentDto));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getStudentsByDegreeLevelDoctor")
    public ResponseEntity<List<StudentDto>> getStudentsByDegreeLevelDoctor(@RequestParam String degreeLevel) {
        List<Student> studentsDoctor = studentService
                .getStudentsByDegreeLevelDoctor(degreeLevel);
        if (!studentsDoctor.isEmpty()) {
            List<StudentDto> studentDtoList = StudentMapper.mapToStudentsDto(studentsDoctor);
            return ResponseEntity.ok(studentDtoList);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getStudentsByDegreeLevelMaster")
    public ResponseEntity<List<StudentDto>> getStudentsByDegreeLevelMaster(@RequestParam String degreeLevel) {
        List<Student> studentsMaster = studentService
                .getStudentsByDegreeLevelMaster(degreeLevel);
        if (!studentsMaster.isEmpty()) {
            List<StudentDto> studentDtoList = StudentMapper.mapToStudentsDto(studentsMaster);
            return ResponseEntity.ok(studentDtoList);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getStudentsByDegreeLevelBachelor")
    public ResponseEntity<List<StudentDto>> getStudentsByDegreeLevelBachelor(@RequestParam String degreeLevel) {
        List<Student> studentsBachelor = studentService
                .getStudentsByDegreeLevelBachelor(degreeLevel);
        if (!studentsBachelor.isEmpty()) {
            List<StudentDto> studentDtoList = StudentMapper.mapToStudentsDto(studentsBachelor);
            return ResponseEntity.ok(studentDtoList);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAllStudentsWithPagination")
    public Page<Student> findAllStudentsWithPagination(
            @RequestParam(defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(defaultValue = "5", required = false) Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return studentService.findAllStudentsWithPagination(pageable);
    }

    @GetMapping("/findAllStudentsByCourse")
    public Page<Student> findAllStudentsWithPagination(
            @RequestParam String courseName,
            @RequestParam(defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(defaultValue = "5", required = false) Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return studentService.findAllStudentsWithPagination(courseName, pageable);
    }


}


