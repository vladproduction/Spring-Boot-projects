package com.vladproduction.model.doctor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by vladproduction on 29-Mar-24
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Doctor {

    @Id
    private int id;
    private String name;
    private String specialist;

}
