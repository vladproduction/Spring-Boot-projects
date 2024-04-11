package com.vladproduction.springdatajpamapping.repository;

import com.vladproduction.springdatajpamapping.entity.Course;
import com.vladproduction.springdatajpamapping.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial(){

        Course course = Course.builder()
                .title("Java basic 2024")
                .credit(200)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.java-basic.com")
                .course(course)
                .build();

        //after cascading we path the permissions to child element

        repository.save(courseMaterial);
    }

    //after fetch type (EAGER or LAZY)
    @Test
    public void printAllCourseMaterials(){
        //LAZY defined here now
        //also to run this method have to @ToString(exclude = "course") in CourseMaterial
        List<CourseMaterial> courseMaterials = repository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);

    }
}