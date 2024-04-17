package com.vladproduction.jpabasic.entity;

/**
 * Created by vladproduction on 14-Apr-24
 */

public enum Degree {
    BACHELOR("Bachelor's Degree"), //<30
    MASTER("Master's Degree"), //>=30
    DOCTOR("Doctoral Degree"); // >=60

    private final String fullName;

    Degree(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
