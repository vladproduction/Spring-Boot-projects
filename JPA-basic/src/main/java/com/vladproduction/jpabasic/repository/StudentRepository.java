package com.vladproduction.jpabasic.repository;

import com.vladproduction.jpabasic.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by vladproduction on 12-Apr-24
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByStudentEmail(String studentEmail);

    Optional<Student> findStudentByLastName(String lastName);

//    Optional<List<Student>> findStudentsByAcademicPerformanceDegree_Doctor();
//
//    Optional<List<Student>> findStudentsByAcademicPerformanceDegree_Master();
//
//    Optional<List<Student>> findStudentsByAcademicPerformanceDegree_Bachelor();
}
