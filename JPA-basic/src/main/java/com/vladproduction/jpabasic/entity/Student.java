package com.vladproduction.jpabasic.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Created by vladproduction on 12-Apr-24
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(
        name = "tbl_student",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "student_email_unique",
                        columnNames = "student_email"
                )
        }
)

public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "student_id",
            updatable = false
    )
    private Long studentId;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "student_email",
            nullable = false,
            columnDefinition = "VARCHAR(255)"
    )
    private String studentEmail;

    @Column(
            name = "age",
            nullable = false,
            columnDefinition = "INT"
    )
    private Integer studentAge;

    @Embedded
    private AcademicPerformance academicPerformance;
}
