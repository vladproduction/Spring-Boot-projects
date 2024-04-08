package com.vladproduction.springtransactions.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by vladproduction on 30-Mar-24
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int acc_number;
    private double balance;



}
