package com.vladproduction.jpabasic.service;

import com.vladproduction.jpabasic.entity.Student;
import com.vladproduction.jpabasic.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Student> getStudentsByDegreeLevelDoctor(String degreeLevel) {
        List<Student> students = studentRepository
                .findAll();
        List<Student> doctors = new ArrayList<>();
        for (Student student : students) {
            if (student.getAcademicPerformance().getDegree().name().equals(degreeLevel)) {
                doctors.add(student);
            }
        }
        return doctors;
    }

    public List<Student> getStudentsByDegreeLevelMaster(String degreeLevel) {
        List<Student> students = studentRepository
                .findAll();
        List<Student> doctors = new ArrayList<>();
        for (Student student : students) {
            if (student.getAcademicPerformance().getDegree().name().equals(degreeLevel)) {
                doctors.add(student);
            }
        }
        return doctors;
    }

    public List<Student> getStudentsByDegreeLevelBachelor(String degreeLevel) {
        List<Student> students = studentRepository
                .findAll();
        List<Student> doctors = new ArrayList<>();
        for (Student student : students) {
            if (student.getAcademicPerformance().getDegree().name().equals(degreeLevel)) {
                doctors.add(student);
            }
        }
        return doctors;
    }

    public Page<Student> findAllStudentsWithPagination(Pageable pageable) {
        return studentRepository
                .findAllStudentsWithPagination(pageable);
    }

    public Page<Student> findAllStudentsWithPagination(String curseName, Pageable pageable) {
        return studentRepository
                .findAllStudentsWithPagination(curseName, pageable);
    }


}
