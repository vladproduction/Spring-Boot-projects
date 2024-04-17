package com.vladproduction.jpabasic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Created by vladproduction on 15-Apr-24
 */

@Data
@AllArgsConstructor
@Builder
public class InstructorDto {

    private String firstName;
    private String lastName;
    private String instructorPhone;
    private Integer experience;
    private DepartmentDto departmentDto;
}
