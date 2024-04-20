package com.vladproduction.jpabasic.controller;

import com.vladproduction.jpabasic.dto.StudentDto;
import com.vladproduction.jpabasic.entity.AcademicPerformance;
import com.vladproduction.jpabasic.entity.Degree;
import com.vladproduction.jpabasic.entity.Student;
import com.vladproduction.jpabasic.service.StudentService;
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
import java.util.List;

import static com.vladproduction.jpabasic.utils.JsonUtils.toJson;
import static com.vladproduction.jpabasic.utils.RandomDataGenerator.uniqueEmail;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Testcontainers
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentService studentService;

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
    public void saveStudentTest() throws Exception {

        String baseEmailName = "test";
        String baseEmailExtend = "@gmail.com";

        Student student = Student.builder()
                .firstName("firstName")
                .lastName("lastName")
                .studentEmail(uniqueEmail(baseEmailName, baseEmailExtend))
                .studentAge(33)
                .academicPerformance(AcademicPerformance.builder()
                        .degree(Degree.BACHELOR)
                        .value(100)
                        .build())
                .build();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/jpa-basic/saveStudent")
                        .contentType("application/json")
                        .content(toJson(student))
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentEmail").exists());

    }

    @Test
    public void findAllStudentsTest() throws Exception {
        String baseEmailName = "test";
        String baseEmailExtend = "@gmail.com";

        StudentDto studentDto1 = StudentDto.builder()
                .firstName("firstName")
                .lastName("lastName")
                .studentEmail(uniqueEmail(baseEmailName, baseEmailExtend))
                .studentAge(33)
                .academicPerformance(AcademicPerformance.builder()
                        .degree(Degree.BACHELOR)
                        .value(100)
                        .build())
                .build();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/jpa-basic/saveStudent")
                        .contentType("application/json")
                        .content(toJson(studentDto1))
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentEmail").exists());


        StudentDto studentDto2 = StudentDto.builder()
                .firstName("firstName")
                .lastName("lastName")
                .studentEmail(uniqueEmail(baseEmailName, baseEmailExtend))
                .studentAge(33)
                .academicPerformance(AcademicPerformance.builder()
                        .degree(Degree.BACHELOR)
                        .value(100)
                        .build())
                .build();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/jpa-basic/saveStudent")
                        .contentType("application/json")
                        .content(toJson(studentDto2))
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentEmail").exists());

        StudentDto studentDto3 = StudentDto.builder()
                .firstName("firstName")
                .lastName("lastName")
                .studentEmail(uniqueEmail(baseEmailName, baseEmailExtend))
                .studentAge(33)
                .academicPerformance(AcademicPerformance.builder()
                        .degree(Degree.BACHELOR)
                        .value(100)
                        .build())
                .build();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/jpa-basic/saveStudent")
                        .contentType("application/json")
                        .content(toJson(studentDto3))
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentEmail").exists());

        List<StudentDto> studentsDtoList = new ArrayList<>();
        studentsDtoList.add(studentDto1);
        studentsDtoList.add(studentDto2);
        studentsDtoList.add(studentDto3);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/jpa-basic/findAllStudents")
                        .contentType("application/json")
                        .content(studentsDtoList.toString())
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findStudentByIdTest() throws Exception {

        String baseEmailName = "test";
        String baseEmailExtend = "@gmail.com";


        Student student = Student.builder()
                .firstName("firstName")
                .lastName("lastName")
                .studentEmail(uniqueEmail(baseEmailName, baseEmailExtend))
                .studentAge(33)
                .academicPerformance(AcademicPerformance.builder()
                        .degree(Degree.DOCTOR)
                        .value(100)
                        .build())
                .build();

        Student saveStudent = studentService.saveStudent(student);

        Long student_id = saveStudent.getStudentId();

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/jpa-basic/findStudentById/{studentId}", student_id)
                        .contentType("application/json")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findStudentByEmailTest() throws Exception {

        String baseEmailName = "test";
        String baseEmailExtend = "@gmail.com";

        //creating
        Student student = Student.builder()
                .firstName("firstName")
                .lastName("lastName")
                .studentEmail(uniqueEmail(baseEmailName, baseEmailExtend))
                .studentAge(33)
                .academicPerformance(AcademicPerformance.builder()
                        .degree(Degree.DOCTOR)
                        .value(100)
                        .build())
                .build();

       //saving
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/jpa-basic/saveStudent")
                        .contentType("application/json")
                        .content(toJson(student))
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentEmail").exists());

        // GET request to find student by email
        String studentEmail = student.getStudentEmail(); // Access email directly from saved
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/jpa-basic/findStudentByEmail")
                        .param("studentEmail", studentEmail)
                        .contentType("application/json")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentEmail").value(studentEmail))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(student.getFirstName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value(student.getLastName()));
    }

    @Test
    public void findStudentByLastNameTest() throws Exception{
        String baseEmailName = "test";
        String baseEmailExtend = "@gmail.com";

        Student student = Student.builder()
                .firstName("firstName")
                .lastName("lastName1")
                .studentEmail(uniqueEmail(baseEmailName, baseEmailExtend))
                .studentAge(33)
                .academicPerformance(AcademicPerformance.builder()
                        .degree(Degree.DOCTOR)
                        .value(100)
                        .build())
                .build();
        Student saveStudent = studentService.saveStudent(student);
        String lastName = saveStudent.getLastName();

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/jpa-basic/findStudentByLastName")
                        .param("lastName", lastName)
                        .contentType("application/json")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getStudentsByDegreeLevelDoctorTest() throws Exception {
        String baseEmailName = "test";
        String baseEmailExtend = "@gmail.com";

        Student student = Student.builder()
                .firstName("firstName")
                .lastName("lastName")
                .studentEmail(uniqueEmail(baseEmailName, baseEmailExtend))
                .studentAge(33)
                .academicPerformance(AcademicPerformance.builder()
                        .degree(Degree.DOCTOR)
                        .value(100)
                        .build())
                .build();
        Student saveStudent = studentService.saveStudent(student);
        String degreeLevel = saveStudent.getAcademicPerformance().getDegree().name();

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/jpa-basic/getStudentsByDegreeLevelDoctor")
                        .param("degreeLevel", degreeLevel)
                        .contentType("application/json")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getStudentsByDegreeLevelMasterTest() throws Exception {
        String baseEmailName = "test";
        String baseEmailExtend = "@gmail.com";

        Student student = Student.builder()
                .firstName("firstName")
                .lastName("lastName")
                .studentEmail(uniqueEmail(baseEmailName, baseEmailExtend))
                .studentAge(33)
                .academicPerformance(AcademicPerformance.builder()
                        .degree(Degree.MASTER)
                        .value(100)
                        .build())
                .build();
        Student saveStudent = studentService.saveStudent(student);
        String degreeLevel = saveStudent.getAcademicPerformance().getDegree().name();

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/jpa-basic/getStudentsByDegreeLevelMaster")
                        .param("degreeLevel", degreeLevel)
                        .contentType("application/json")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getStudentsByDegreeLevelBachelorTest() throws Exception {
        String baseEmailName = "test";
        String baseEmailExtend = "@gmail.com";

        Student student = Student.builder()
                .firstName("firstName")
                .lastName("lastName")
                .studentEmail(uniqueEmail(baseEmailName, baseEmailExtend))
                .studentAge(33)
                .academicPerformance(AcademicPerformance.builder()
                        .degree(Degree.BACHELOR)
                        .value(100)
                        .build())
                .build();
        Student saveStudent = studentService.saveStudent(student);
        String degreeLevel = saveStudent.getAcademicPerformance().getDegree().name();

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/jpa-basic/getStudentsByDegreeLevelBachelor")
                        .param("degreeLevel", degreeLevel)
                        .contentType("application/json")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}

