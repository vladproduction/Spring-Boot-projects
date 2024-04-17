package com.vladproduction.jpabasic.controller;

import com.vladproduction.jpabasic.dto.CourseDto;
import com.vladproduction.jpabasic.dto.DepartmentDto;
import com.vladproduction.jpabasic.dto.InstructorDto;
import com.vladproduction.jpabasic.dto.StudentDto;
import com.vladproduction.jpabasic.entity.Course;
import com.vladproduction.jpabasic.entity.Department;
import com.vladproduction.jpabasic.entity.Instructor;
import com.vladproduction.jpabasic.entity.Student;
import com.vladproduction.jpabasic.mapper.CourseMapper;
import com.vladproduction.jpabasic.mapper.StudentMapper;
import com.vladproduction.jpabasic.service.CourseService;
import com.vladproduction.jpabasic.service.DepartmentService;
import com.vladproduction.jpabasic.service.InstructorService;
import com.vladproduction.jpabasic.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by vladproduction on 17-Apr-24
 */

@RestController
@RequestMapping("api/jpa-basic")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private InstructorService instructorService;
    @Autowired
    private StudentService studentService;

    @PostMapping("/saveCourse")
    public ResponseEntity<CourseDto> saveCourse(
            @RequestBody CourseDto courseDto){
        Course course = CourseMapper.mapToCourse(courseDto);
        //Department
        DepartmentDto departmentDto = courseDto.getDepartmentDto();
        if(departmentDto != null){
            if(departmentDto.getDepartmentName() != null){
                Optional<Department> optionalDepartment = departmentService
                        .findByDepartmentName(departmentDto.getDepartmentName());
                optionalDepartment.ifPresent(course::setDepartment);
            }
        }
        //Instructor
        InstructorDto instructorDto = courseDto.getInstructorDto();
        if(instructorDto != null){
            if (instructorDto.getDepartmentDto() != null){
                Optional<Instructor> optionalInstructor = instructorService
                        .findInstructorByDepartmentDepartmentName(instructorDto.getDepartmentDto().getDepartmentName());
                optionalInstructor.ifPresent(course::setInstructor);
            }
        }
        //List<Student>
        List<StudentDto> studentsDto = courseDto.getStudentsDto();
        List<Student> students = StudentMapper.mapToStudents(studentsDto);
        List<Student> studentList = new ArrayList<>();
        for(Student student: students){
            Optional<Student> studentOptional = studentService.findStudentByStudentEmail(student.getStudentEmail());
            studentOptional.ifPresent(studentList::add);
        }
        course.setStudents(studentList);
        Course savedCourse = courseService.saveCourse(course);
        CourseDto savedCourseDto = CourseMapper.mapToCourseDto(savedCourse);
        return ResponseEntity.ok(savedCourseDto);
    }

    @GetMapping("/findAllCourses")
    public ResponseEntity<List<CourseDto>> findAllCourses(){
        List<Course> allCourses = courseService.findAllCourses();
        List<CourseDto> courseDtoList = CourseMapper.mapToCoursesDto(allCourses);
        return ResponseEntity.ok(courseDtoList);
    }

    @GetMapping("/findCourseById/{courseId}")
    public ResponseEntity<Optional<CourseDto>> findCourseById(
            @PathVariable Long courseId){
        Optional<Course> optionalCourse = courseService.findCourseById(courseId);
        if(optionalCourse.isPresent()){
            CourseDto courseDto = CourseMapper.mapToCourseDto(optionalCourse.get());
            return ResponseEntity.ok(Optional.of(courseDto));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findByCourseName")
    public ResponseEntity<Optional<CourseDto>> findByCourseName(
            @RequestParam String courseName){
        Optional<Course> optionalCourse = courseService.findByCourseName(courseName);
        if(optionalCourse.isPresent()){
            CourseDto courseDto = CourseMapper.mapToCourseDto(optionalCourse.get());
            return ResponseEntity.ok(Optional.of(courseDto));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findCoursesByDuration/{courseDuration}")
    public ResponseEntity<Optional<List<CourseDto>>> findCoursesByCourseDuration(
            @PathVariable Integer courseDuration){
        Optional<List<Course>> optionalCourses = courseService.findCoursesByCourseDuration(courseDuration);
        if (optionalCourses.isPresent()){
            List<CourseDto> courseDtoList = CourseMapper.mapToCoursesDto(optionalCourses.get());
            return ResponseEntity.ok(Optional.of(courseDtoList));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findCoursesByInstructorLastName")
    public ResponseEntity<Optional<List<CourseDto>>> findCoursesByInstructorLastName(
            @RequestParam String lastName){
        Optional<List<Course>> coursesByInstructorLastName = courseService.findCoursesByInstructorLastName(lastName);
        if(coursesByInstructorLastName.isPresent()){
            List<CourseDto> courseDtoList = CourseMapper.mapToCoursesDto(coursesByInstructorLastName.get());
            return ResponseEntity.ok(Optional.of(courseDtoList));
        }
        return ResponseEntity.notFound().build();
    }


}
