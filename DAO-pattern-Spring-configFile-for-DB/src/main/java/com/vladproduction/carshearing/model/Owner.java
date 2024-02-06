package com.vladproduction.carshearing.model;

import java.util.Objects;


public class Owner {


//    private int id;

    private String name;

    private String surname;

    private String phone;

    public Owner() {
    }

    public Owner(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    @Override
//    public boolean equals(Object object) {
//        if (this == object) return true;
//        if (object == null || getClass() != object.getClass()) return false;
//        Owner owner = (Owner) object;
//        return id == owner.id && Objects.equals(name, owner.name) && Objects.equals(surname, owner.surname) && Objects.equals(phone, owner.phone);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, surname, phone);
//    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Owner owner = (Owner) object;
        return Objects.equals(name, owner.name) && Objects.equals(surname, owner.surname) && Objects.equals(phone, owner.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, phone);
    }

//    @Override
//    public String toString() {
//        return "Owner{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", phone='" + phone + '\'' +
//                '}';
//    }


    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
