package com.vladproduction.jpabasic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by vladproduction on 16-Apr-24
 */

@Data
@AllArgsConstructor
@Builder
public class CourseDto {

    private String courseName;
    private Integer courseDuration;
    private List<StudentDto> studentsDto;
    private InstructorDto instructorDto;
    private DepartmentDto departmentDto;
}
