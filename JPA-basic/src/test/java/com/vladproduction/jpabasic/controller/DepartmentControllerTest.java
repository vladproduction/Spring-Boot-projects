//package com.vladproduction.jpabasic.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.vladproduction.jpabasic.dto.DepartmentDto;
//import com.vladproduction.jpabasic.entity.Department;
//import com.vladproduction.jpabasic.mapper.DepartmentMapper;
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
//import java.util.Optional;
//import java.util.Random;
//
//import static com.vladproduction.jpabasic.utils.JsonUtils.toJson;
//import static com.vladproduction.jpabasic.utils.RandomDataGenerator.uniqueContactPhone;
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
//@Testcontainers
//class DepartmentControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Container
//    static MySQLContainer mySQLContainer = new MySQLContainer(
//            "mysql:8.3.0"
//    );
//
//    @DynamicPropertySource
//    static void dynamicConfiguration(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
//        registry.add("spring.datasource.username", mySQLContainer::getUsername);
//        registry.add("spring.datasource.password", mySQLContainer::getPassword);
//    }
//
//    @Test
//    public void saveDepartmentTest() throws Exception {
//
//        String baseContactPhone = "050";
//
//        Department department = Department.builder()
//                .name("Java")
//                .location("Ohio")
//                .contactPhone(uniqueContactPhone(baseContactPhone))
//                .build();
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/jpa-basic/saveDepartment")
//                        .contentType("application/json")
//                        .content(toJson(department))
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.contactPhone").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.location").exists());
//
//    }
//
//    @Test
//    public void findAllDepartmentsTest() throws Exception {
//
//        String baseContactPhone = "050";
//
//        Department department1 = Department.builder()
//                .name("Java")
//                .location("Ohio")
//                .contactPhone(uniqueContactPhone(baseContactPhone))
//                .build();
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/jpa-basic/saveDepartment")
//                        .contentType("application/json")
//                        .content(toJson(department1))
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.contactPhone").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.location").exists());
//
//        Department department2 = Department.builder()
//                .name("Java")
//                .location("Ohio")
//                .contactPhone(uniqueContactPhone(baseContactPhone))
//                .build();
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/jpa-basic/saveDepartment")
//                        .contentType("application/json")
//                        .content(toJson(department2))
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.contactPhone").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.location").exists());
//
//        Department department3 = Department.builder()
//                .name("Java")
//                .location("Ohio")
//                .contactPhone(uniqueContactPhone(baseContactPhone))
//                .build();
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/jpa-basic/saveDepartment")
//                        .contentType("application/json")
//                        .content(toJson(department3))
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.contactPhone").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.location").exists());
//
//        List<Department> savedDepartments = new ArrayList<>();
//        savedDepartments.add(department1);
//        savedDepartments.add(department2);
//        savedDepartments.add(department3);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/jpa-basic/findAllDepartments")
//                        .contentType("application/json")
//                        .content(savedDepartments.toString())
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
//    }
//
//    @Test
//    public void findDepartmentByIdTest() throws Exception{
//
//        String baseContactPhone = "050";
//        Long randomDepartmentId = new Random().nextLong(1, 99);
//
//        Department department = Department.builder()
//                .departmentId(randomDepartmentId)
//                .name("Java")
//                .contactPhone(uniqueContactPhone(baseContactPhone))
//                .location("Ohio")
//                .build();
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/jpa-basic/saveDepartment")
//                        .contentType("application/json")
//                        .content(toJson(department))
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentId").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.contactPhone").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.location").exists())
//                .andReturn();
//
//        Long department_id = department.getDepartmentId();
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/jpa-basic/findDepartmentById/{departmentId}", department_id)
//                        .contentType("application/json")
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
//    }
//
//    @Test
//    public void findByContactPhoneTest() throws Exception{
//
//        String baseContactPhone = "050";
//        Long randomDepartmentId = new Random().nextLong(1, 99);
//
//        Department department = Department.builder()
//                .departmentId(randomDepartmentId)
//                .name("Java")
//                .contactPhone(uniqueContactPhone(baseContactPhone))
//                .location("Ohio")
//                .build();
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/jpa-basic/saveDepartment")
//                        .contentType("application/json")
//                        .content(toJson(department))
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.contactPhone").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.location").exists())
//                .andReturn();
//
//        String savedContactPhone = department.getContactPhone();
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/jpa-basic/findByContactPhone")
//                        .param("contactPhone", savedContactPhone)
//                        .contentType("application/json")
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.contactPhone").value(savedContactPhone));
//    }
//
//    @Test
//    public void findDepartmentByNameTest() throws Exception{
//
//        String baseContactPhone = "050";
//        Long randomDepartmentId = new Random().nextLong(1, 99);
//
//        Department department = Department.builder()
//                .departmentId(randomDepartmentId)
//                .name("Java")
//                .contactPhone(uniqueContactPhone(baseContactPhone))
//                .location("Ohio")
//                .build();
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/jpa-basic/saveDepartment")
//                        .contentType("application/json")
//                        .content(toJson(department))
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.contactPhone").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.location").exists())
//                .andReturn();
//
//        String savedName = department.getName();
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/jpa-basic/findDepartmentByName")
//                        .param("department", savedName)
//                        .contentType("application/json")
//                        .accept("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(savedName));
//    }
//
//
//}