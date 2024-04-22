package com.vladproduction.jpabasic.controller;

import com.vladproduction.jpabasic.dto.DepartmentDto;
import com.vladproduction.jpabasic.dto.InstructorDto;
import com.vladproduction.jpabasic.dto.StudentDto;
import com.vladproduction.jpabasic.entity.Department;
import com.vladproduction.jpabasic.entity.Instructor;
import com.vladproduction.jpabasic.mapper.DepartmentMapper;
import com.vladproduction.jpabasic.mapper.InstructorMapper;
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

import java.util.ArrayList;
import java.util.List;
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
        //need to return List<InstructorDto>

        //1)create department and save+
        //2)create instructors and save+
        //3)check using assertThat savedDepartment(response) is equal from departmentService.findByDepartmentName(...)+
        //4)find all saved instructors from mockMvc+
        //5)assertThat response and using instructorService.findAllInstructors are equal

        /**1)create department and save*/
        DepartmentDto departmentDto = DepartmentDto.builder()
                .departmentName("AI")
                .departmentPhone("111")
                .departmentLocation("Ohio")
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

        /**2)create instructors and save*/
        //instructor1
        InstructorDto instructor1 = InstructorDto.builder()
                .firstName("First-Inst1")
                .lastName("Last-Inst1")
                .instructorPhone("test-phone-101")
                .experience(100)
                .departmentDto(departmentDtoSaved)
                .build();
        var savedInstructor1 = mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/jpa-basic/saveInstructor")
                        .contentType("application/json")
                        .content(toJson(instructor1))
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        //instructor2
        InstructorDto instructor2 = InstructorDto.builder()
                .firstName("First-Inst2")
                .lastName("Last-Inst2")
                .instructorPhone("test-phone-102")
                .experience(100)
                .departmentDto(departmentDtoSaved)
                .build();
        var savedInstructor2 = mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/jpa-basic/saveInstructor")
                        .contentType("application/json")
                        .content(toJson(instructor2))
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        /**3)check using assertThat savedDepartment(response) is equal from departmentService.findByDepartmentName(...)*/
        System.out.println("savedDepartment = " + savedDepartment.getResponse().getContentAsString());
        String depName = departmentDtoSaved.getDepartmentName();
        //for instructor1
        assertThat(toJson(depName))
                .isEqualTo(toJson(instructor1.getDepartmentDto().getDepartmentName()));
        //for instructor2
        assertThat(toJson(depName))
                .isEqualTo(toJson(instructor2.getDepartmentDto().getDepartmentName()));
        System.out.println("depName = " + depName);

        /**4)find all saved instructors from mockMvc*/
        //create list of instructorDtoList been saved, and paste it in content of response
        List<InstructorDto> instructorDtoList = new ArrayList<>();
        instructorDtoList.add(instructor1);
        instructorDtoList.add(instructor2);

        var savedInstructorsDtoResponse = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/jpa-basic/findAllInstructors")
                        .contentType("application/json")
                        .content(instructorDtoList.toString())
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        /**5)assertThat response and using instructorService.findAllInstructors are equal*/
        //just print response
        System.out.println("savedInstructorsDtoResponse = " + savedInstructorsDtoResponse.getResponse().getContentAsString());
        //making assertion
        List<Instructor> allInstructors = instructorService.findAllInstructors();
        List<InstructorDto> savedInstructorsDtoFromInstructorService = InstructorMapper.mapToInstructorsDto(allInstructors);
        assertThat(savedInstructorsDtoResponse.getResponse().getContentAsString())
                .isEqualTo(toJson(savedInstructorsDtoFromInstructorService));


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