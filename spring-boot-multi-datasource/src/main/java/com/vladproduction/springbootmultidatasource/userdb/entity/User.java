package com.vladproduction.springbootmultidatasource.userdb.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Created by vladproduction on 10-Apr-24
 */
@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;


}
