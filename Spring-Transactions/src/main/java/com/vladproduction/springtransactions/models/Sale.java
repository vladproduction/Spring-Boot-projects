package com.vladproduction.springtransactions.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by vladproduction on 31-Mar-24
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sale_info;
    private double price;

}
