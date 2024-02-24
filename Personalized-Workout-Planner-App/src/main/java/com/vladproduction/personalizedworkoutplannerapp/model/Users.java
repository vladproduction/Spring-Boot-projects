package com.vladproduction.personalizedworkoutplannerapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Getter
@Setter
@ToString
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private int user_id;
    @Column(name = "login", nullable = false, length = 45)
    private String login;
    @Column(name = "email", unique = true, nullable = false, length = 45)
    private String email;
    @Column(name = "password", nullable = false, length = 45)
    private String password;
    @Column(name = "first_name", nullable = false, length = 45)
    private String first_name;
    @Column(name = "last_name", nullable = false, length = 45)
    private String last_name;
    @Column(name = "goals", nullable = false, length = 45)
    private String goals;
    @Column(name = "experience", nullable = false, length = 45)
    private String experience;
    @Column(name = "preferences", nullable = false, length = 45)
    private String preferences;


}
