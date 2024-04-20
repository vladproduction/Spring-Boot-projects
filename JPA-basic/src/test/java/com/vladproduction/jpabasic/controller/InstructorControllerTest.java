package com.vladproduction.jpabasic.controller;

import com.vladproduction.jpabasic.dto.DepartmentDto;
import com.vladproduction.jpabasic.dto.InstructorDto;
import com.vladproduction.jpabasic.entity.Department;
import com.vladproduction.jpabasic.mapper.DepartmentMapper;
import com.vladproduction.jpabasic.service.DepartmentService;
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

import java.util.Optional;

import static com.vladproduction.jpabasic.utils.JsonUtils.toJson;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Testcontainers
class InstructorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private InstructorService instructorService;
    @Autowired
    private DepartmentService departmentService;
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
    void saveInstructor() throws Exception {
        DepartmentDto departmentDto = DepartmentDto.builder()
                .departmentName("Java")
                .departmentPhone("123")
                .departmentLocation("Location")
                .build();
        var savedDepartment = mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/jpa-basic/saveDepartment")
                        .contentType("application/json")
                        .content(toJson(departmentDto))
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Optional<Department> optionalDepartment = departmentService.findByDepartmentName(departmentDto.getDepartmentName());
        Department departmentOpt = optionalDepartment.get();
        DepartmentDto departmentDtoSaved = DepartmentMapper.mapToDepartmentDto(departmentOpt);

        InstructorDto instructor = InstructorDto.builder()
                .firstName("first")
                .lastName("last")
                .instructorPhone("test-phone-111")
                .experience(100)
                .departmentDto(departmentDtoSaved) // Use the saved department
                .build();
        var savedInstructor = mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/jpa-basic/saveInstructor")
                        .contentType("application/json")
                        .content(toJson(instructor))
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        System.out.println("savedDepartment = " + savedDepartment.getResponse().getContentAsString());
        System.out.println("savedInstructor = " + savedInstructor.getResponse().getContentAsString());


        assertThat(savedInstructor.getResponse().getContentAsString())
                .isEqualTo(toJson(instructor));

        String depName = departmentDtoSaved.getDepartmentName();
        assertThat(toJson(depName))
                .isEqualTo(toJson(instructor.getDepartmentDto().getDepartmentName()));
        System.out.println("depName = " + depName);

    }

    @Test
    void findAllInstructors() throws Exception {

//        Department department = Department.builder()
//                .departmentName("TestDepartment")
//                .departmentPhone("123")
//                .departmentLocation("TestLocation")
//                .build();
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/jpa-basic/saveDepartment")
//                        .contentType("application/json")
//                        .content(toJson(department))
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
//        Instructor instructor = Instructor.builder()
//                .firstName("first")
//                .lastName("last")
//                .instructorPhone("test-phone-111")
//                .experience(100)
//                .department(department)
//                .build();
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/jpa-basic/saveInstructor")
//                        .contentType("application/json")
//                        .content(toJson(instructor))
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
//        var result = mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/jpa-basic/findAllInstructors")
//                        .contentType("application/json")
////                        .content(toJson(instructor))
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andReturn();
//
//        System.out.println("result = " + result.getResponse().getContentAsString());
//





    }

    @Test
    void findInstructorById() {
    }

    @Test
    void findByExperience() {
    }

    @Test
    void findByFirstNameAndLastName() {
    }

    @Test
    void findByInstructorPhone() {
    }

    @Test
    void findInstructorByDepartmentDepartmentName() {
    }
}

/**creating content:
//        Department department = Department.builder()
//                .departmentName("TestDepartment")
//                .departmentPhone("12345")
//                .departmentLocation("TestLocation")
//                .build();
String baseContactPhone = "050";

Department department = Department.builder()
        .departmentName("Java")
        .departmentLocation("Ohio")
        .departmentPhone(uniqueContactPhone(baseContactPhone))
        .build();

        mockMvc.perform(MockMvcRequestBuilders
                                .post("/api/jpa-basic/saveDepartment")
                        .contentType("application/json")
                        .content(toJson(department))
        .accept("application/json"))
        .andExpect(MockMvcResultMatchers.status().isOk());

Instructor instructor1 = Instructor.builder()
        .firstName("first1")
        .lastName("last1")
        .instructorPhone("test-phone-111")
        .experience(100)
        .department(department)
        .build();
Instructor instructor2 = Instructor.builder()
        .firstName("first2")
        .lastName("last2")
        .instructorPhone("test-phone-112")
        .experience(100)
        .department(department)
        .build();
Instructor instructor3 = Instructor.builder()
        .firstName("first3")
        .lastName("last3")
        .instructorPhone("test-phone-113")
        .experience(100)
        .department(department)
        .build();

//save content
        mockMvc.perform(MockMvcRequestBuilders
                                .post("/api/jpa-basic/saveInstructor")
                        .contentType("application/json")
                        .content(toJson(instructor1))
        .accept("application/json"))
        .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders
                                .post("/api/jpa-basic/saveInstructor")
                        .contentType("application/json")
                        .content(toJson(instructor2))
        .accept("application/json"))
        .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders
                                .post("/api/jpa-basic/saveInstructor")
                        .contentType("application/json")
                        .content(toJson(instructor3))
        .accept("application/json"))
        .andExpect(MockMvcResultMatchers.status().isOk());

//        List<Instructor> instructors = instructorRepository.saveAll(List.of(instructor1, instructor2, instructor3));
//        List<InstructorDto> instructorDtoList = InstructorMapper.mapToInstructorsDto(instructors);

//check for saving is done
List<Instructor> instructorList = new ArrayList<>();
        instructorList.add(instructor1);
        instructorList.add(instructor2);
        instructorList.add(instructor3);

List<InstructorDto> instructorDtoList = InstructorMapper.mapToInstructorsDto(instructorList);

//        List<Instructor> allInstructors = instructorRepository.findAll();
//        assertThat(allInstructors).isNotNull();

//[GET] response
var result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/jpa-basic/findAllInstructors")
                .contentType("application/json")
                .content(instructorList.toString())
                .accept("application/json"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();

assertThat(result.getResponse().getContentAsString())
        .isEqualTo(toJson(instructorList));*/

/** DepartmentDto department = DepartmentDto.builder()
 .departmentName("TestDepartment")
 .departmentPhone("123")
 .departmentLocation("TestLocation")
 .build();
 var savedDepartment = mockMvc.perform(MockMvcRequestBuilders
 .post("/api/jpa-basic/saveDepartment")
 .contentType("application/json")
 .content(toJson(department))
 .accept("application/json"))
 .andExpect(MockMvcResultMatchers.status().isOk())
 .andReturn();
 Optional<Department> optionalDepartment = departmentService.findByDepartmentName(department.getDepartmentName());

 Department departmentActual = optionalDepartment.get();
 DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(departmentActual);



 Instructor instructor = Instructor.builder()
 .firstName("first")
 .lastName("last")
 .instructorPhone("test-phone-111")
 .experience(100)
 .department(departmentActual)
 .build();
 var savedInstructor = mockMvc.perform(MockMvcRequestBuilders
 .post("/api/jpa-basic/saveInstructor")
 .contentType("application/json")
 .content(toJson(instructor))
 .accept("application/json"))
 .andExpect(MockMvcResultMatchers.status().isOk())
 .andReturn();

 System.out.println("savedDepartment = " + savedDepartment.getResponse().getContentAsString());
 System.out.println("savedInstructor = " + savedInstructor.getResponse().getContentAsString());*/