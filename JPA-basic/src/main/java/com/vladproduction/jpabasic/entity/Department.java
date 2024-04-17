package com.vladproduction.jpabasic.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Created by vladproduction on 14-Apr-24
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(
        name = "tbl_department",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "department_phone",
                        columnNames = "department_phone"
                )
        }
)
public class Department {

    @Id
    @SequenceGenerator(
            name = "department_sequence",
            sequenceName = "department_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_sequence"
    )
    @Column(
            name = "department_id",
            updatable = false
    )
    private Long departmentId;

    @Column(
            name = "department",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String departmentName;

    @Column(
            name = "department_phone",
            nullable = false,
            columnDefinition = "VARCHAR(255)"
    )
    private String departmentPhone;

    @Column(
            name = "location",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String departmentLocation;
}
