package com.vladproduction.jpabasic.service;

import com.vladproduction.jpabasic.entity.Course;
import com.vladproduction.jpabasic.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by vladproduction on 16-Apr-24
 */

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(Course course) {
        return courseRepository
                .save(course);
    }

    public List<Course> findAllCourses() {
        return courseRepository
                .findAll();
    }

    public Optional<Course> findCourseById(Long courseId) {
        return courseRepository
                .findById(courseId);
    }

    public Optional<Course> findByCourseName(String courseName) {
        return courseRepository
                .findByCourseName(courseName);
    }

    public Optional<List<Course>> findCoursesByCourseDuration(Integer courseDuration) {
        return courseRepository
                .findCoursesByCourseDuration(courseDuration);
    }

    public Optional<List<Course>> findCoursesByInstructorLastName(String lastName) {
        return courseRepository
                .findCoursesByInstructorLastName(lastName);
    }


}
