package com.vladproduction.jpabasic.controller;

import com.vladproduction.jpabasic.dto.StudentDto;
import com.vladproduction.jpabasic.entity.Student;
import com.vladproduction.jpabasic.mapper.StudentMapper;
import com.vladproduction.jpabasic.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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
        if (studentByEmail.isPresent()){
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
        if(studentByLastName.isPresent()){
            Student student = studentByLastName.get();
            StudentDto studentDto = StudentMapper.mapToStudentDto(student);
            return ResponseEntity.ok(Optional.of(studentDto));
        }
        return ResponseEntity.notFound().build();
    }

//    @GetMapping("/findStudentsByDegree_Doctor")
//    public ResponseEntity<Optional<List<StudentDto>>> findStudentsByAcademicPerformanceDegree_Doctor() {
//        Optional<List<Student>> studentsDoctor = studentService
//                .findStudentsByAcademicPerformanceDegree_Doctor();
//        if(studentsDoctor.isPresent()){
//            List<Student> students = studentsDoctor.get();
//            List<StudentDto> studentDtoList = StudentMapper.mapToStudentsDto(students);
//            return ResponseEntity.ok(Optional.of(studentDtoList));
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @GetMapping("/findStudentsByDegree_Master")
//    public ResponseEntity<Optional<List<StudentDto>>> findStudentsByAcademicPerformanceDegree_Master() {
//        Optional<List<Student>> studentsMaster = studentService
//                .findStudentsByAcademicPerformanceDegree_Master();
//        if(studentsMaster.isPresent()){
//            List<Student> students = studentsMaster.get();
//            List<StudentDto> studentDtoList = StudentMapper.mapToStudentsDto(students);
//            return ResponseEntity.ok(Optional.of(studentDtoList));
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @GetMapping("/findStudentsByDegree_Bachelor")
//    public ResponseEntity<Optional<List<StudentDto>>> findStudentsByAcademicPerformanceDegree_Bachelor() {
//        Optional<List<Student>> studentsBachelor = studentService
//                .findStudentsByAcademicPerformanceDegree_Bachelor();
//        if(studentsBachelor.isPresent()){
//            List<Student> students = studentsBachelor.get();
//            List<StudentDto> studentDtoList = StudentMapper.mapToStudentsDto(students);
//            return ResponseEntity.ok(Optional.of(studentDtoList));
//        }
//        return ResponseEntity.notFound().build();
//    }

}
