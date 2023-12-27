package com.vladproduction.repositories;

import com.vladproduction.data.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByFirstNameStartsWith(String s);

}
