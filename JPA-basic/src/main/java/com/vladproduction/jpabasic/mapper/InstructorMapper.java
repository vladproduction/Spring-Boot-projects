package com.vladproduction.jpabasic.mapper;

import com.vladproduction.jpabasic.dto.InstructorDto;
import com.vladproduction.jpabasic.dto.StudentDto;
import com.vladproduction.jpabasic.entity.Instructor;
import com.vladproduction.jpabasic.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladproduction on 16-Apr-24
 */

public class InstructorMapper {

    //dto --> instructor
    public static Instructor mapToInstructor(InstructorDto instructorDto) {
        Instructor instructor = Instructor.builder()
                .firstName(instructorDto.getFirstName())
                .lastName(instructorDto.getLastName())
                .instructorPhone(instructorDto.getInstructorPhone())
                .experience(instructorDto.getExperience())
                .department(DepartmentMapper.mapToDepartment(instructorDto.getDepartmentDto()))
                .build();
        return instructor;

    }

    /**
     * private String firstName;
     * private String lastName;
     * private String instructorPhone;
     * private Integer experience;
     * ---------relation----------------------
     * private DepartmentDto departmentDto;
     */

    //instructor --> dto
    public static InstructorDto mapToInstructorDto(Instructor instructor) {
        InstructorDto instructorDto = InstructorDto.builder()
                .firstName(instructor.getFirstName())
                .lastName(instructor.getLastName())
                .instructorPhone(instructor.getInstructorPhone())
                .experience(instructor.getExperience())
                .departmentDto(DepartmentMapper.mapToDepartmentDto(instructor.getDepartment()))
                .build();
        return instructorDto;
    }

    public static List<InstructorDto> mapToInstructorsDto(List<Instructor> instructorList){
        List<InstructorDto> instructorDtoList = new ArrayList<>();
        for (Instructor instructor : instructorList) {
            instructorDtoList.add(mapToInstructorDto(instructor));
        }
        return instructorDtoList;
    }

    public static List<Instructor> mapToInstructors(List<InstructorDto> instructorDtoList){
        List<Instructor> instructors = new ArrayList<>();
        for (InstructorDto instructor : instructorDtoList) {
            instructors.add(mapToInstructor(instructor));
        }
        return instructors;
    }


}
