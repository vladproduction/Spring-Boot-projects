package com.vladproduction.jpabasic.mapper;

import com.vladproduction.jpabasic.dto.StudentDto;
import com.vladproduction.jpabasic.entity.AcademicPerformance;
import com.vladproduction.jpabasic.entity.Degree;
import com.vladproduction.jpabasic.entity.Student;

import java.util.Random;

/**
 * Created by vladproduction on 12-Apr-24
 */

public class StudentMapper {

    //dto --> student
    public static Student mapToStudent(StudentDto studentDto) {
        Student student = Student.builder()
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .email(studentDto.getEmail())
                .age(studentDto.getAge())
                .academicPerformance(AcademicPerformance.builder()
                        .degree(studentDto.getAcademicPerformance().getDegree())
                        .value(studentDto.getAcademicPerformance().getValue())
                        .build())
                .build();
        return student;
    }

    //student --> dto
    public static StudentDto mapToStudentDto(Student student) {
        StudentDto studentDto = StudentDto.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .age(student.getAge())
                .academicPerformance(AcademicPerformance.builder()
                        .degree(student.getAcademicPerformance().getDegree())
                        .value(student.getAcademicPerformance().getValue())
                        .build())
                .build();
        return studentDto;
    }

}
