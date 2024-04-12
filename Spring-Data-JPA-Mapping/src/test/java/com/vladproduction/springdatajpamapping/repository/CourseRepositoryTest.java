package com.vladproduction.springdatajpamapping.repository;

import com.vladproduction.springdatajpamapping.entity.Course;
import com.vladproduction.springdatajpamapping.entity.Guardian;
import com.vladproduction.springdatajpamapping.entity.Student;
import com.vladproduction.springdatajpamapping.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void findAllPagination(){

        Pageable firstPageWith3Records = PageRequest.of(0, 3);
        Pageable secondPageWith2Records = PageRequest.of(1, 2);

        List<Course> courses = repository.findAll(secondPageWith2Records).getContent();
        Long totalElements = repository.findAll(secondPageWith2Records).getTotalElements();
        long totalPages = repository.findAll(secondPageWith2Records).getTotalPages();
        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(
                0,
                2,
                Sort.by("title")
        );
        Pageable sortByCreditDesc = PageRequest.of(
                0,
                2,
                Sort.by("credit").descending()
        );
        Pageable sortByTitleAndCreditDesc = PageRequest.of(
                0,
                2,
                Sort.by("title")
                        .descending()
                        .and(Sort.by("credit"))

        );

        List<Course> coursesByTitle = repository.findAll(sortByTitle).getContent();
        System.out.println("coursesByTitle = " + coursesByTitle);

        List<Course> coursesByCredit = repository.findAll(sortByCreditDesc).getContent();
        System.out.println("coursesByCredit = " + coursesByCredit);

        List<Course> coursesByTitleAndCredit = repository.findAll(sortByTitleAndCreditDesc).getContent();
        System.out.println("coursesByTitleAndCredit = " + coursesByTitleAndCredit);
    }

    @Test
    public void printFindByTitleContaining(){

        Pageable firstPage10Records = PageRequest.of(0, 10);

        List<Course> courses = repository.findByTitleContaining(
                "J",
                firstPage10Records).getContent();

        System.out.println("courses = " + courses);

    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Frank")
                .lastName("Lampard")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(230)
                .teacher(teacher)
                .build();

        Student student = Student.builder()
                .firstName("Maggy")
                .lastName("Dow")
                .emailId("maggydow@gmail.com")
                .guardian(new Guardian("Mark Dow", "DowMark@gmail.com", "11112222"))
                .build();

        course.addStudents(student);

        repository.save(course);

    }



}