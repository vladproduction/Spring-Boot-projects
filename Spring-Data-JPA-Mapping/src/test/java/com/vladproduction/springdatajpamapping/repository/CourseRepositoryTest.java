package com.vladproduction.springdatajpamapping.repository;

import com.vladproduction.springdatajpamapping.entity.Course;
import com.vladproduction.springdatajpamapping.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void printCoursesTest(){

        List<Course> courses = repository.findAll();
        System.out.println("courses = " + courses);

    }

    @Test
    public void countCoursesAmountTest(){

        long count = repository.count();
        System.out.println("count = " + count);

    }

    @Test
    public void saveCourseWithTeacherTest(){

        Teacher teacher = Teacher.builder()
                .firstName("Alvaro")
                .lastName("Recoba")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(75)
                .teacher(teacher)
                .build();

        repository.save(course);

    }



}