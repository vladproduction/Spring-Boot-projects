package com.vladproduction.jpabasic.mapper;

import com.vladproduction.jpabasic.dto.CourseDto;
import com.vladproduction.jpabasic.entity.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladproduction on 16-Apr-24
 */

public class CourseMapper {

    //dto --> course
    public static Course mapToCourse(CourseDto courseDto) {


        Course course = Course.builder()
                .courseName(courseDto.getCourseName())
                .courseDuration(courseDto.getCourseDuration())
                .students(StudentMapper.mapToStudents(courseDto.getStudentsDto()))
                .instructor(InstructorMapper.mapToInstructor(courseDto.getInstructorDto()))
                .department(DepartmentMapper.mapToDepartment(courseDto.getDepartmentDto()))
                .build();
        return course;

    }

    /**
     * private String courseName;;
     * private Integer courseDuration;
     * private List<StudentDto> studentsDto;
     * private InstructorDto instructorDto;
     * private DepartmentDto departmentDto;
     */
    //course --> dto
    public static CourseDto mapToCourseDto(Course course) {

        CourseDto courseDto = CourseDto.builder()
                .courseName(course.getCourseName())
                .courseDuration(course.getCourseDuration())
                .studentsDto(StudentMapper.mapToStudentsDto(course.getStudents()))
                .instructorDto(InstructorMapper.mapToInstructorDto(course.getInstructor()))
                .departmentDto(DepartmentMapper.mapToDepartmentDto(course.getDepartment()))
                .build();
        return courseDto;
    }

    public static List<CourseDto> mapToCoursesDto(List<Course> courses){
        List<CourseDto> courseDtoList = new ArrayList<>();
        for (Course course : courses) {
            courseDtoList.add(mapToCourseDto(course));
        }
        return courseDtoList;
    }

    public static List<Course> mapToCourses(List<CourseDto> coursesDto){
        List<Course> courses = new ArrayList<>();
        for (CourseDto courseDto : coursesDto) {
            courses.add(mapToCourse(courseDto));
        }
        return courses;
    }

}
