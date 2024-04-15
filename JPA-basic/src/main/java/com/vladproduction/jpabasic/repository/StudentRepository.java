package com.vladproduction.jpabasic.repository;

import com.vladproduction.jpabasic.dto.StudentDto;
import com.vladproduction.jpabasic.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by vladproduction on 12-Apr-24
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    StudentDto findStudentByEmail(String email);
}
