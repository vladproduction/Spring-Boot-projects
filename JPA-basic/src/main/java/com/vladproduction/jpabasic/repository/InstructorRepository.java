package com.vladproduction.jpabasic.repository;

import com.vladproduction.jpabasic.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by vladproduction on 16-Apr-24
 */

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    Optional<List<Instructor>> findByExperience(Integer experience);

    Optional<Instructor> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<Instructor> findByInstructorPhone(String instructorPhone);

    Optional<Instructor> findInstructorByDepartmentDepartmentName(String departmentName);
}
