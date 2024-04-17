package com.vladproduction.jpabasic.mapper;

import com.vladproduction.jpabasic.dto.StudentDto;
import com.vladproduction.jpabasic.entity.AcademicPerformance;
import com.vladproduction.jpabasic.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladproduction on 12-Apr-24
 */

public class StudentMapper {

    //dto --> student
    public static Student mapToStudent(StudentDto studentDto) {
        Student student = Student.builder()
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .studentEmail(studentDto.getStudentEmail())
                .studentAge(studentDto.getStudentAge())
                .academicPerformance(AcademicPerformance.builder()
                        .degree(studentDto.getAcademicPerformance().getDegree())
                        .value(studentDto.getAcademicPerformance().getValue())
                        .build())
                .build();
        return student;
    }

    /**
     * private String firstName;
     * private String lastName;
     * private String studentEmail;
     * private int studentAge;
     * private AcademicPerformance academicPerformance;
     */

    //student --> dto
    public static StudentDto mapToStudentDto(Student student) {
        StudentDto studentDto = StudentDto.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .studentEmail(student.getStudentEmail())
                .studentAge(student.getStudentAge())
                .academicPerformance(AcademicPerformance.builder()
                        .degree(student.getAcademicPerformance().getDegree())
                        .value(student.getAcademicPerformance().getValue())
                        .build())
                .build();
        return studentDto;
    }

    public static List<StudentDto> mapToStudentsDto(List<Student> students) {
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (Student student : students) {
            studentDtoList.add(mapToStudentDto(student));
        }
        return studentDtoList;
    }

    public static List<Student> mapToStudents(List<StudentDto> studentsDto) {
        List<Student> studentList = new ArrayList<>();
        for (StudentDto studentDto : studentsDto) {
            studentList.add(mapToStudent(studentDto));
        }
        return studentList;
    }

}
