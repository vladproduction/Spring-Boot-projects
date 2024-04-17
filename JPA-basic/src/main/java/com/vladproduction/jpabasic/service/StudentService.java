package com.vladproduction.jpabasic.service;

import com.vladproduction.jpabasic.entity.Student;
import com.vladproduction.jpabasic.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by vladproduction on 12-Apr-24
 */

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository
                .save(student);
    }

    public List<Student> findAllStudents() {
        return studentRepository
                .findAll();
    }

    public Optional<Student> findStudentById(Long studentId) {
        return studentRepository
                .findById(studentId);
    }

    public Optional<Student> findStudentByStudentEmail(String studentEmail) {
        return studentRepository
                .findStudentByStudentEmail(studentEmail);
    }

    public Optional<Student> findStudentByLastName(String lastName) {
        return studentRepository
                .findStudentByLastName(lastName);
    }

//    public Optional<List<Student>> findStudentsByAcademicPerformanceDegree_Doctor() {
//        return studentRepository
//                .findStudentsByAcademicPerformanceDegree_Doctor();
//    }
//
//    public Optional<List<Student>> findStudentsByAcademicPerformanceDegree_Master() {
//        return studentRepository
//                .findStudentsByAcademicPerformanceDegree_Master();
//    }
//
//    public Optional<List<Student>> findStudentsByAcademicPerformanceDegree_Bachelor() {
//        return studentRepository
//                .findStudentsByAcademicPerformanceDegree_Bachelor();
//    }


}
