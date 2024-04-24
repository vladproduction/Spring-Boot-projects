package com.vladproduction.jpabasic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vladproduction.jpabasic.dto.CourseDto;
import com.vladproduction.jpabasic.entity.*;
import com.vladproduction.jpabasic.mapper.CourseMapper;
import com.vladproduction.jpabasic.service.CourseService;
import com.vladproduction.jpabasic.service.InstructorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.ArrayList;

import static com.vladproduction.jpabasic.utils.JsonUtils.toJson;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Testcontainers
class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CourseService courseService;

    @Container
    static MySQLContainer mySQLContainer = new MySQLContainer(
            "mysql:8.3.0"
    );

    //providing settings for remote source:
    @DynamicPropertySource
    static void dynamicConfiguration(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mySQLContainer::getUsername);
        registry.add("spring.datasource.password", mySQLContainer::getPassword);
    }

    @Test
    void saveCourse() throws Exception {

//        Course course = Course.builder()
//                .courseId(1L)
//                .courseName("Spring")
//                .courseDuration(200)
//
//                .department(Department.builder()
//                        .departmentId(1L)
//                        .departmentName("Java")
//                        .departmentPhone("123123123")
//                        .departmentLocation("Ohio")
//                        .build())
//
//                .instructor(Instructor.builder()
//                        .instructorId(1L)
//                        .firstName("Karlo")
//                        .lastName("Tell")
//                        .instructorPhone("123123777")
//                        .experience(100)
//                        .department.departmentName("Java")
//
//                        .build())
//
//                .students(new ArrayList<>(){
//                    Student student1 = Student.builder()
//                            .studentId(1L)
//                            .firstName("AAA")
//                            .lastName("aaa")
//                            .studentEmail("aaa@test.com")
//                            .academicPerformance(AcademicPerformance.builder()
//                                    .degree(Degree.MASTER)
//                                    .value(110)
//                                    .build())
//                            .build();
//                    Student student2 = Student.builder()
//                            .studentId(1L)
//                            .firstName("BBB")
//                            .lastName("bbb")
//                            .studentEmail("bbb@test.com")
//                            .academicPerformance(AcademicPerformance.builder()
//                                    .degree(Degree.MASTER)
//                                    .value(110)
//                                    .build())
//                            .build();
//                    Student student3 = Student.builder()
//                            .studentId(1L)
//                            .firstName("BBB")
//                            .lastName("bbb")
//                            .studentEmail("bbb@test.com")
//                            .academicPerformance(AcademicPerformance.builder()
//                                    .degree(Degree.MASTER)
//                                    .value(110)
//                                    .build())
//                            .build();
//
//                })
//                .build();
//
//        Course savedCourse = courseService.saveCourse(course);
//        CourseDto courseDto = CourseMapper.mapToCourseDto(savedCourse);
//
//        var resultSavedCourse = mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/jpa-basic/saveCourse")
//                        .contentType("application/json")
//                        .content(toJson(course))
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andReturn();
//
//        assertThat(courseDto).isEqualTo(resultSavedCourse.getResponse().getContentAsString());


    }

    @Test
    void findAllCourses() {
    }

    @Test
    void findCourseById() {
    }

    @Test
    void findByCourseName() {
    }

    @Test
    void findCoursesByCourseDuration() {
    }

    @Test
    void findCoursesByInstructorLastName() {
    }
}