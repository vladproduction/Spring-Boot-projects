package com.vladproduction.springbootextratopics.entity;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private int capacity;
    private int price;

    public Room() {
    }

    public Room(long id, String name, String description, int capacity, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id && capacity == room.capacity && price == room.price && Objects.equals(name, room.name) && Objects.equals(description, room.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, capacity, price);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }
}
