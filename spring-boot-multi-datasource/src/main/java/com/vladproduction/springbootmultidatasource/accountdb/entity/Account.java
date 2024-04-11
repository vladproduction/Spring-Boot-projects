package com.vladproduction.springbootmultidatasource.accountdb.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Created by vladproduction on 10-Apr-24
 */
@Entity
@Data
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "website")
    private String website;

}
