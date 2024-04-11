package com.vladproduction.springdatajpamapping.repository;

import com.vladproduction.springdatajpamapping.entity.Course;
import com.vladproduction.springdatajpamapping.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacherTest(){

        Course courseJDBC = Course.builder()
                .title("JDBC")
                .credit(25)
                .build();
        Course courseMYSQL = Course.builder()
                .title("MYSQL")
                .credit(50)
                .build();
        Course coursePATTERNS = Course.builder()
                .title("PATTERNS")
                .credit(25)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Evan")
                .lastName("Bengtsson")
//                .courses(List.of(courseJDBC, courseMYSQL, coursePATTERNS))
                .build();

        teacherRepository.save(teacher);
    }

}