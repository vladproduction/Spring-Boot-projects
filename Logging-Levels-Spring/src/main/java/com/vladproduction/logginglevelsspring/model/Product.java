package com.vladproduction.logginglevelsspring.model;

/**
 * Created by vladproduction on 13-Mar-24
 */

public class Product {

    private Long id;

    public Product(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                '}';
    }
}
