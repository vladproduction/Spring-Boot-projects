package com.vladproduction.springbootcinemabookingservice.model.impl;

import com.vladproduction.springbootcinemabookingservice.model.UserModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String email;

    private String name;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Ticket> tickets;

    @OneToOne(mappedBy = "user")
    private UserAccount account;

}
