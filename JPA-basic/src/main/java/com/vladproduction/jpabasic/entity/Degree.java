package com.vladproduction.jpabasic.entity;

/**
 * Created by vladproduction on 14-Apr-24
 */

public enum Degree {
    BACHELOR("Bachelor's Degree"),
    MASTER("Master's Degree"),
    DOCTOR("Doctoral Degree");

    private final String fullName;

    Degree(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
