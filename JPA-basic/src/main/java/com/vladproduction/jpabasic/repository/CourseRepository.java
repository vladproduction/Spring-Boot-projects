package com.vladproduction.jpabasic.repository;

import com.vladproduction.jpabasic.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by vladproduction on 16-Apr-24
 */

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByCourseName(String courseName);

    Optional<List<Course>> findCoursesByCourseDuration(Integer courseDuration);

    Optional<List<Course>> findCoursesByInstructorLastName(String lastName);


}
