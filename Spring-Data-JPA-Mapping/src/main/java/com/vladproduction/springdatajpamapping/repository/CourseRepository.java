package com.vladproduction.springdatajpamapping.repository;

import com.vladproduction.springdatajpamapping.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vladproduction on 11-Apr-24
 */

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
