package com.vladproduction.restValidation.models;

import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public class InnerUserObject {
    @NotBlank(message = "InnerUserObject.name; should be not blank")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        InnerUserObject that = (InnerUserObject) object;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "InnerUserObject{" +
                "name='" + name + '\'' +
                '}';
    }
}
