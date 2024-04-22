package com.vladproduction.jpabasic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.*;

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
    void findInstructorByIdTest() throws Exception {
        /**1)save content*/
        Instructor instructor = instructorService.saveInstructor(Instructor.builder()
                .instructorId(45L) //have to past some to compile, but by DB is sequence
                .firstName("John")
                .lastName("Dow")
                .instructorPhone("456")
                .experience(23)
                .department(Department.builder()
                        .departmentId(23L)
                        .departmentName("CS")
                        .departmentPhone("236987")
                        .departmentLocation("Ohio")
                        .build())
                .build());
        /**2)took id for [GET] request as path variable value*/
        Long instructorId = instructor.getInstructorId();

        var result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/jpa-basic/findInstructorById/{instructorId}", instructorId)
                        .contentType("application/json")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        //just print resul to see what has been saved
        System.out.println("result = " + result.getResponse().getContentAsString());

        /**3)assertion: took from service potentially saved id and equals to id wanted to be saved*/
        Optional<Instructor> instructorOptional = instructorService.findInstructorById(instructorId);
        Instructor instructorSaved = instructorOptional.get();
        Long savedInstructorId = instructorSaved.getInstructorId();
        assertThat(instructorId).isEqualTo(savedInstructorId);
        System.out.println("instructorId = " + instructorId);
        System.out.println("savedInstructorId = " + savedInstructorId);

        /**4)assertion: saved Instructor has to be same as response result by endpoint*/
        InstructorDto instructorDtoSaved = InstructorMapper.mapToInstructorDto(instructorSaved);
        assertThat(result.getResponse().getContentAsString()).isEqualTo(toJson(instructorDtoSaved));

    }

    @Test
    void findByExperience() throws Exception {
        /**1)save content*/
        Instructor instructor = instructorService.saveInstructor(Instructor.builder()
                .instructorId(43L)
                .firstName("Jack")
                .lastName("Dow")
                .instructorPhone("45987")
                .experience(89)
                .department(Department.builder()
                        .departmentId(21L)
                        .departmentName("DS")
                        .departmentPhone("457287")
                        .departmentLocation("Ohio")
                        .build())
                .build());

        /**2)took experience for [GET] request as path variable value*/
        Integer experience = instructor.getExperience();
        var result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/jpa-basic/findByExperience/{experience}", experience)
                        .contentType("application/json")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        //just print resul to see what has been saved
        System.out.println("result = " + result.getResponse().getContentAsString());

        /**3)assertion: took from service potentially saved experience and equals to experience wanted to be saved*/
        Optional<List<Instructor>> instructorOptional = instructorService.findByExperience(experience);
        List<Instructor> instructors = instructorOptional.get();
        Integer savedExperience = instructors.stream().findFirst().get().getExperience();
        assertThat(experience).isEqualTo(savedExperience);
        System.out.println("experience = " + experience);
        System.out.println("savedExperience = " + savedExperience);

        /**4)assertion: saved Instructor has to be same as response result by endpoint(by experience)*/
        List<InstructorDto> instructorsDtoSaved = InstructorMapper.mapToInstructorsDto(instructors);
        assertThat(result.getResponse().getContentAsString()).isEqualTo(toJson(instructorsDtoSaved));

    }

    @Test
    void findByFirstNameAndLastName() throws Exception {
        /**1)save content*/
        Instructor instructor = instructorService.saveInstructor(Instructor.builder()
                .instructorId(35L)
                .firstName("Jenny")
                .lastName("Dow")
                .instructorPhone("34576")
                .experience(200)
                .department(Department.builder()
                        .departmentId(63L)
                        .departmentName("CompScience")
                        .departmentPhone("2362332")
                        .departmentLocation("Ohio")
                        .build())
                .build());
        /**2)took firstName and lastName for [GET] request as path variable values*/
        String firstName = instructor.getFirstName();
        String lastName = instructor.getLastName();

        var result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/jpa-basic/findByFirstNameAndLastName")
                        .param("firstName",firstName)
                        .param("lastName", lastName)
                        .contentType("application/json")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        //just print resul to see what has been saved
        System.out.println("result = " + result.getResponse().getContentAsString());

        /**3)assertion: took from service potentially saved id and equals to id wanted to be saved*/
        Optional<Instructor> instructorOptional = instructorService.findByFirstNameAndLastName(firstName, lastName);
        Instructor instructorSaved = instructorOptional.get();
        String savedInstructorFirstName = instructorSaved.getFirstName();
        String savedInstructorLastName = instructorSaved.getLastName();
        assertThat(firstName).isEqualTo(savedInstructorFirstName);
        assertThat(lastName).isEqualTo(savedInstructorLastName);
        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);
        System.out.println("savedInstructorFirstName = " + savedInstructorFirstName);
        System.out.println("savedInstructorLastName = " + savedInstructorLastName);

        /**4)assertion: saved Instructor has to be same as response result by endpoint: findByFirstNameAndLastName*/
        InstructorDto instructorDtoSaved = InstructorMapper.mapToInstructorDto(instructorSaved);
        assertThat(result.getResponse().getContentAsString()).isEqualTo(toJson(instructorDtoSaved));
    }

    @Test
    void findByInstructorPhone() throws Exception {
        /**1)save content*/
        Instructor instructor = instructorService.saveInstructor(Instructor.builder()
                .instructorId(55L)
                .firstName("Frank")
                .lastName("Dow")
                .instructorPhone("98076")
                .experience(29)
                .department(Department.builder()
                        .departmentId(63L)
                        .departmentName("ComputerScience")
                        .departmentPhone("23622222")
                        .departmentLocation("Ohio")
                        .build())
                .build());
        /**2)took instructorPhone for [GET] request as path variable value*/
        String instructorPhone = instructor.getInstructorPhone();

        var result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/jpa-basic/findByInstructorPhone")
                        .param("instructorPhone",instructorPhone)
                        .contentType("application/json")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        //just print resul to see what has been saved
        System.out.println("result = " + result.getResponse().getContentAsString());

        /**3)assertion: took from service potentially saved id and equals to id wanted to be saved*/
        Optional<Instructor> instructorOptional = instructorService.findByInstructorPhone(instructorPhone);
        Instructor instructorSaved = instructorOptional.get();
        String savedInstructorPhone = instructorSaved.getInstructorPhone();

        assertThat(instructorPhone).isEqualTo(savedInstructorPhone);
        System.out.println("instructorPhone = " + instructorPhone);
        System.out.println("savedInstructorPhone = " + savedInstructorPhone);


        /**4)assertion: saved Instructor has to be same as response result by endpoint: findByInstructorPhone*/
        InstructorDto instructorDtoSaved = InstructorMapper.mapToInstructorDto(instructorSaved);
        assertThat(result.getResponse().getContentAsString()).isEqualTo(toJson(instructorDtoSaved));
    }

    @Test
    void findInstructorByDepartmentDepartmentName() throws Exception {
        /**1)save content*/
        Instructor instructor = instructorService.saveInstructor(Instructor.builder()
                .instructorId(15L)
                .firstName("Bob")
                .lastName("Dow")
                .instructorPhone("9823376")
                .experience(323)
                .department(Department.builder()
                        .departmentId(43L)
                        .departmentName("CScience")
                        .departmentPhone("23655222")
                        .departmentLocation("Ohio")
                        .build())
                .build());
        /**2)took departmentName for [GET] request as path variable value*/
        String departmentName = instructor.getDepartment().getDepartmentName();

        var result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/jpa-basic/findInstructorByDepartmentName")
                        .param("departmentName",departmentName)
                        .contentType("application/json")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        //just print resul to see what has been saved
        System.out.println("result = " + result.getResponse().getContentAsString());

        /**3)assertion: took from service potentially saved departmentName and equals to departmentName wanted to be saved*/
        Optional<Instructor> instructorOptional = instructorService.findInstructorByDepartmentDepartmentName(departmentName);
        Instructor instructorSaved = instructorOptional.get();
        String savedInstructorDepartmentName = instructorSaved.getDepartment().getDepartmentName();

        assertThat(departmentName).isEqualTo(savedInstructorDepartmentName);
        System.out.println("departmentName = " + departmentName);
        System.out.println("savedInstructorDepartmentName = " + savedInstructorDepartmentName);


        /**4)assertion: saved Instructor has to be same as response result by endpoint: findByInstructorPhone*/
        InstructorDto instructorDtoSaved = InstructorMapper.mapToInstructorDto(instructorSaved);
        assertThat(result.getResponse().getContentAsString()).isEqualTo(toJson(instructorDtoSaved));
    }


}
