package com.vladproduction.jpabasic.dto;

import com.vladproduction.jpabasic.entity.AcademicPerformance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Created by vladproduction on 12-Apr-24
 */

@Data
@AllArgsConstructor
@Builder
public class StudentDto {

    private String firstName;
    private String lastName;
    private String studentEmail;
    private int studentAge;
    private AcademicPerformance academicPerformance;

}
