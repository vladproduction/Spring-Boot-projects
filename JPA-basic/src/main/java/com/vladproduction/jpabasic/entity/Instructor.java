package com.vladproduction.jpabasic.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Created by vladproduction on 15-Apr-24
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(
        name = "tbl_instructor",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "instructor_phone_unique",
                        columnNames = "instructor_phone"
                )
        }
)
public class Instructor {

    @Id
    @SequenceGenerator(
            name = "instructor_sequence",
            sequenceName = "instructor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "instructor_sequence"
    )
    @Column(
            name = "instructor_id",
            updatable = false
    )
    private Long instructorId;

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
            name = "instructor_phone",
            nullable = false,
            columnDefinition = "VARCHAR(255)"
    )
    private String instructorPhone;

    @Column(
            name = "experience",
            nullable = false,
            columnDefinition = "INT"
    )
    private Integer experience;

    //--------------------------------relation---------------------------------------

    /**
     * @ManyToOne: many instructors <-to-> one department
     * An instructor belongs to only one department, but a single department may have multiple instructors.
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
