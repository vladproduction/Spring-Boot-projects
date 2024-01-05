package com.vladproduction.restValidation.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;
import java.util.Objects;

public class User {

    @Min(value = 1, message = "id; should be min-1")
    @Max(value = 20, message = "id; should be max-20")
    private Integer id;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9-]+\\.[A-Za-z]{2,6}$",
            message = "email; should contain as example: teSt12@email.com")
    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$",
            message = "password; must contain: at least (8 characters, one upper, one lower, one digit)")
    private String password;

    @NotBlank(message = "role; should be set")
    private String role;

    @Valid
    @NotNull(message = "InnerUserObject userObject; should be not null")
    private InnerUserObject userObject;

    @Valid
    @NotNull(message = "InnerUserObject userObjectList; should be not null")
    private List<InnerUserObject> userObjectList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public InnerUserObject getUserObject() {
        return userObject;
    }

    public void setUserObject(InnerUserObject userObject) {
        this.userObject = userObject;
    }

    public List<InnerUserObject> getUserObjectList() {
        return userObjectList;
    }

    public void setUserObjectList(List<InnerUserObject> userObjectList) {
        this.userObjectList = userObjectList;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
