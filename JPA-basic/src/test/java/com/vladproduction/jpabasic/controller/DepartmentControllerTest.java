package com.vladproduction.jpabasic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vladproduction.jpabasic.entity.Department;
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

import static com.vladproduction.jpabasic.utils.JsonUtils.toJson;
import static com.vladproduction.jpabasic.utils.RandomDataGenerator.uniqueContactPhone;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Testcontainers
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

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
                .name("Java")
                .location("Ohio")
                .contactPhone(uniqueContactPhone(baseContactPhone))
                .build();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/jpa-basic/saveDepartment")
                        .contentType("application/json")
                        .content(toJson(department))
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.contactPhone").exists());

    }


}