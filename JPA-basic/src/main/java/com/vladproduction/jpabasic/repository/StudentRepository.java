package com.vladproduction.jpabasic.repository;

import com.vladproduction.jpabasic.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by vladproduction on 12-Apr-24
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    Optional<Student> findStudentByStudentEmail(String studentEmail);

    Optional<Student> findStudentByLastName(String lastName);

    @Query("select s from Student s where s.academicPerformance.degree =:degreeLevel")
    List<Student> getStudentsByDegreeLevelDoctor(String degreeLevel);

    @Query("select s from Student s where s.academicPerformance.degree =:degreeLevel")
    List<Student> getStudentsByDegreeLevelMaster(String degreeLevel);

    @Query("select s from Student s where s.academicPerformance.degree =:degreeLevel")
    List<Student> getStudentsByDegreeLevelBachelor(String degreeLevel);

    @Query("select s from Student s")
    Page<Student> findAllStudentsWithPagination(Pageable pageable);

    @Query("select c.students from Course c where c.courseName=:curseName")
    Page<Student> findAllStudentsWithPagination(String curseName, Pageable pageable);
}
