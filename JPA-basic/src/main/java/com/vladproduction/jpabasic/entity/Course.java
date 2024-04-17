package com.vladproduction.jpabasic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Created by vladproduction on 16-Apr-24
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(
        name = "tbl_course"
)
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    @Column(
            name = "course_id",
            updatable = false
    )
    private Long courseId;

    @Column(
            name = "course",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String courseName;

    @Column(
            name = "duration",
            nullable = false,
            columnDefinition = "INT"
    )
    private Integer courseDuration;

    //-----------------------------relation-----------------------------------------

    /**
     * @ManyToMany: many courses <-to-> many students;
     * One course can be enrolled in by multiple students, and one student may be enrolled in various courses,
     * so it is a many-to-many relationships
     */
    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "student_course_mapping",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "course_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "student_id"
            )
    )
    private List<Student> students;


    /**
     * @ManyToOne: many courses <-to-> one instructor;
     * An instructor can teach multiple courses, but one course is taught by only one instructor.
     * This is a many-to-one relationships
     */
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "instructor_id",
            referencedColumnName = "instructor_id"
    )
    private Instructor instructor;


    /**
     * @ManyToOne: many courses <-to-> one department;
     * One department offers multiple courses, so this is a many-to-one relationships
     */
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "department_id",
            referencedColumnName = "department_id"
    )
    private Department department;

}
