package com.vladproduction.jpabasic.service;

import com.vladproduction.jpabasic.dto.StudentDto;
import com.vladproduction.jpabasic.entity.Student;
import com.vladproduction.jpabasic.mapper.StudentMapper;
import com.vladproduction.jpabasic.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public StudentDto saveStudent(Student student){
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    public List<StudentDto> findAllStudents(){
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (Student student : students) {
            studentDtoList.add(StudentMapper.mapToStudentDto(student));
        }
        return studentDtoList;
    }

    public Optional<StudentDto> findStudentById(Long studentId){
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            StudentDto studentDto = StudentMapper.mapToStudentDto(student);
            return Optional.of(studentDto);
        }
        return Optional.empty();
    }

    public StudentDto findStudentByEmail(String email){

        return studentRepository.findStudentByEmail(email);
    }

}
