package com.vladproduction.jpabasic.service;

import com.vladproduction.jpabasic.dto.InstructorDto;
import com.vladproduction.jpabasic.entity.Instructor;
import com.vladproduction.jpabasic.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by vladproduction on 16-Apr-24
 */

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;


    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository
                .save(instructor);
    }

    public List<Instructor> findAllInstructors() {
        return instructorRepository
                .findAll();
    }

    public Optional<Instructor> findInstructorById(Long instructorId) {
        return instructorRepository
                .findById(instructorId);
    }

    public Optional<List<Instructor>> findByExperience(Integer experience) {
        return instructorRepository
                .findByExperience(experience);
    }

    public Optional<Instructor> findByFirstNameAndLastName(String firstName, String lastName) {
        return instructorRepository
                .findByFirstNameAndLastName(firstName, lastName);
    }

    public Optional<Instructor> findByInstructorPhone(String instructorPhone) {
        return instructorRepository
                .findByInstructorPhone(instructorPhone);
    }

    public Optional<Instructor> findInstructorByDepartmentDepartmentName(String departmentName) {
        return instructorRepository
                .findInstructorByDepartmentDepartmentName(departmentName);
    }

}
