package com.vladproduction.logginglevelsspring.model;

import java.time.Instant;

/**
 * Created by vladproduction on 12-Mar-24
 */

public class Employee {

    private String firstName;
    private String lastName;
    private int age;
    private Instant hiringDate;
    private Role role;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Instant getHiringDate() {

        return hiringDate;
    }

    public void setHiringDate(Instant hiringDate) {
        this.hiringDate = hiringDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", hiringDate=" + hiringDate +
                ", role=" + role +
                '}';
    }
}
