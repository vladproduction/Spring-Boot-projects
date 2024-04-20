package com.vladproduction.jpabasic.controller;

import com.vladproduction.jpabasic.entity.Department;
import com.vladproduction.jpabasic.service.DepartmentService;
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
import static com.vladproduction.jpabasic.utils.RandomDataGenerator.uniqueContactPhone;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Testcontainers
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DepartmentService departmentService;

    @Container
    static MySQLContainer mySQLContainer = new MySQLContainer(
            "mysql:8.3.0"
    );

    @DynamicPropertySource
    static void dynamicConfiguration(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mySQLContainer::getUsername);
        registry.add("spring.datasource.password", mySQLContainer::getPassword);
    }

    @Test
    public void saveDepartmentTest() throws Exception {

        String baseContactPhone = "050";

        Department department = Department.builder()
                .departmentName("Java")
                .departmentLocation("Ohio")
                .departmentPhone(uniqueContactPhone(baseContactPhone))
                .build();

        var res = mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/jpa-basic/saveDepartment")
                        .contentType("application/json")
                        .content(toJson(department))
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentPhone").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentLocation").exists())
                .andReturn();

        System.out.println("res = " + res.getResponse().getContentAsString());
    }

    @Test
    public void findAllDepartmentsTest() throws Exception {

        String baseContactPhone = "050";

        Department department1 = Department.builder()
                .departmentName("Java")
                .departmentLocation("Ohio")
                .departmentPhone(uniqueContactPhone(baseContactPhone))
                .build();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/jpa-basic/saveDepartment")
                        .contentType("application/json")
                        .content(toJson(department1))
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentPhone").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentLocation").exists());

        Department department2 = Department.builder()
                .departmentName("Java")
                .departmentLocation("Ohio")
                .departmentPhone(uniqueContactPhone(baseContactPhone))
                .build();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/jpa-basic/saveDepartment")
                        .contentType("application/json")
                        .content(toJson(department2))
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentPhone").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentLocation").exists());

        Department department3 = Department.builder()
                .departmentName("Java")
                .departmentLocation("Ohio")
                .departmentPhone(uniqueContactPhone(baseContactPhone))
                .build();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/jpa-basic/saveDepartment")
                        .contentType("application/json")
                        .content(toJson(department3))
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentPhone").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentLocation").exists());

        List<Department> savedDepartments = new ArrayList<>();
        savedDepartments.add(department1);
        savedDepartments.add(department2);
        savedDepartments.add(department3);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/jpa-basic/findAllDepartments")
                        .contentType("application/json")
                        .content(savedDepartments.toString())
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void findDepartmentByIdTest() throws Exception{
        String baseContactPhone = "050";
        Department department = Department.builder()
                .departmentName("Java")
                .departmentLocation("Ohio")
                .departmentPhone(uniqueContactPhone(baseContactPhone))
                .build();

        Department savedDepartment = departmentService.saveDepartment(department);

        Long id = savedDepartment.getDepartmentId();

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/jpa-basic/findDepartmentById/{departmentId}", id)
                        .contentType("application/json")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findDepartmentByLocationTest() throws Exception{
        String baseContactPhone = "050";

        Department department = Department.builder()
                .departmentName("Java")
                .departmentLocation("Chicago")
                .departmentPhone(uniqueContactPhone(baseContactPhone))
                .build();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/jpa-basic/saveDepartment")
                        .contentType("application/json")
                        .content(toJson(department))
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentPhone").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentLocation").exists());

        String departmentLocation = department.getDepartmentLocation();

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/jpa-basic/findDepartmentByLocation")
                        .param("departmentLocation", departmentLocation)
                        .contentType("application/json")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentLocation").value(departmentLocation));
    }

    @Test
    public void findByDepartmentPhoneTest() throws Exception{

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
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentPhone").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentLocation").exists());

        String departmentPhone = department.getDepartmentPhone();

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/jpa-basic/findByDepartmentPhone")
                        .param("departmentPhone", departmentPhone)
                        .contentType("application/json")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentPhone").value(departmentPhone));
    }

    @Test
    public void findDepartmentByNameTest() throws Exception{
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
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentPhone").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentLocation").exists())
                .andReturn();

        String departmentName = department.getDepartmentName();

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/jpa-basic/findByDepartmentName")
                        .param("departmentName", departmentName)
                        .contentType("application/json")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(departmentName));
    }


}