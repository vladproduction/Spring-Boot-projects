//package com.vladproduction.jpabasic.controller;
//
//import com.vladproduction.jpabasic.dto.StudentDto;
//import com.vladproduction.jpabasic.entity.AcademicPerformance;
//import com.vladproduction.jpabasic.entity.Degree;
//import com.vladproduction.jpabasic.entity.Student;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.testcontainers.containers.MySQLContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//import static com.vladproduction.jpabasic.utils.JsonUtils.toJson;
//import static com.vladproduction.jpabasic.utils.RandomDataGenerator.uniqueEmail;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
//@Testcontainers
//class StudentControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Container
//    static MySQLContainer mySQLContainer = new MySQLContainer(
//            "mysql:8.3.0"
//    );
//
//    //providing settings for remote source:
//    @DynamicPropertySource
//    static void dynamicConfiguration(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
//        registry.add("spring.datasource.username", mySQLContainer::getUsername);
//        registry.add("spring.datasource.password", mySQLContainer::getPassword);
//    }
//
//    @Test
//    public void saveStudentTest() throws Exception {
//
//        String baseEmailName = "test";
//        String baseEmailExtend = "@gmail.com";
//
//        StudentDto studentDto = StudentDto.builder()
//                .firstName("firstName")
//                .lastName("lastName")
//                .email(uniqueEmail(baseEmailName, baseEmailExtend))
//                .age(33)
//                .academicPerformance(AcademicPerformance.builder()
//                        .degree(Degree.BACHELOR)
//                        .value(100)
//                        .build())
//                .build();
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/jpa-basic/saveStudent")
//                        .contentType("application/json")
//                        .content(toJson(studentDto))
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.email").exists());
//
//    }
//
//    @Test
//    public void findAllStudentsTest() throws Exception {
//        String baseEmailName = "test";
//        String baseEmailExtend = "@gmail.com";
//
//        StudentDto studentDto1 = StudentDto.builder()
//                .firstName("firstName")
//                .lastName("lastName")
//                .email(uniqueEmail(baseEmailName, baseEmailExtend))
//                .age(33)
//                .academicPerformance(AcademicPerformance.builder()
//                        .degree(Degree.BACHELOR)
//                        .value(100)
//                        .build())
//                .build();
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/jpa-basic/saveStudent")
//                        .contentType("application/json")
//                        .content(toJson(studentDto1))
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.email").exists());
//
//
//        StudentDto studentDto2 = StudentDto.builder()
//                .firstName("firstName")
//                .lastName("lastName")
//                .email(uniqueEmail(baseEmailName, baseEmailExtend))
//                .age(33)
//                .academicPerformance(AcademicPerformance.builder()
//                        .degree(Degree.MASTER)
//                        .value(100)
//                        .build())
//                .build();
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/jpa-basic/saveStudent")
//                        .contentType("application/json")
//                        .content(toJson(studentDto2))
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.email").exists());
//
//        StudentDto studentDto3 = StudentDto.builder()
//                .firstName("firstName")
//                .lastName("lastName")
//                .email(uniqueEmail(baseEmailName, baseEmailExtend))
//                .age(33)
//                .academicPerformance(AcademicPerformance.builder()
//                        .degree(Degree.DOCTOR)
//                        .value(100)
//                        .build())
//                .build();
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/jpa-basic/saveStudent")
//                        .contentType("application/json")
//                        .content(toJson(studentDto3))
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.email").exists());
//
//        List<StudentDto> studentsDtoList = new ArrayList<>();
//        studentsDtoList.add(studentDto1);
//        studentsDtoList.add(studentDto2);
//        studentsDtoList.add(studentDto3);
//        System.out.println("=====studentsDtoList===== \n" + studentsDtoList);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/jpa-basic/findAllStudents")
//                        .contentType("application/json")
//                        .content(studentsDtoList.toString())
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    public void findStudentByIdTest() throws Exception {
//
//        String baseEmailName = "test";
//        String baseEmailExtend = "@gmail.com";
//        Long studentId = new Random().nextLong(100, 999);
//
//        Student student = Student.builder()
//                .studentId(studentId)
//                .firstName("firstName")
//                .lastName("lastName")
//                .email(uniqueEmail(baseEmailName, baseEmailExtend))
//                .age(33)
//                .academicPerformance(AcademicPerformance.builder()
//                        .degree(Degree.DOCTOR)
//                        .value(100)
//                        .build())
//                .build();
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/jpa-basic/saveStudent")
//                        .contentType("application/json")
//                        .content(toJson(student))
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.email").exists())
//                .andReturn();
//
//        Long student_id = student.getStudentId();
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/jpa-basic/findStudentById/{studentId}", student_id)
//                        .contentType("application/json")
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    public void findStudentByEmailTest() throws Exception {
//
//        String baseEmailName = "test";
//        String baseEmailExtend = "@gmail.com";
//
//        StudentDto studentDto = StudentDto.builder()
//                .firstName("firstName")
//                .lastName("lastName")
//                .email(uniqueEmail(baseEmailName, baseEmailExtend))
//                .age(33)
//                .academicPerformance(AcademicPerformance.builder()
//                        .degree(Degree.DOCTOR)
//                        .value(100)
//                        .build())
//                .build();
//
//       //saving
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/jpa-basic/saveStudent")
//                        .contentType("application/json")
//                        .content(toJson(studentDto))
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.email").exists());
//
//        // GET request to find student by email
//        String savedEmail = studentDto.getEmail(); // Access email directly from saved DTO
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/jpa-basic/findStudentByEmail")
//                        .param("email", savedEmail)
//                        .contentType("application/json")
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(savedEmail)) // Verifying email in response
//                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(studentDto.getFirstName())) // Optionally verifying other fields
//                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value(studentDto.getLastName())); // ...
//    }
//
//
//}