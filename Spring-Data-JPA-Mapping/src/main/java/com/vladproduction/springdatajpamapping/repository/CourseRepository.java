package com.vladproduction.springdatajpamapping.repository;

import com.vladproduction.springdatajpamapping.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vladproduction on 11-Apr-24
 */

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    //custom methods:
    Page<Course> findByTitleContaining(
            String title,
            Pageable pageRequest
    );
}
