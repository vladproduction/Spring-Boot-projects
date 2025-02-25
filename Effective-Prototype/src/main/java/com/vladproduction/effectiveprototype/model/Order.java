package com.vladproduction.effectiveprototype.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



/**
 * Core Order class - not modified
 * */

public final class Order {

    private final String id;
    private final LocalDateTime createdAt;
    private String status = "NEW";
    private final List<String> items = new ArrayList<>();


    public Order(String id, LocalDateTime createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

    public String getId() { return id; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<String> getItems() { return items; }
    public void addItem(String item) { this.items.add(item); }

    @Override
    public String toString() {
        return "Order{id='" + id + "', createdAt=" + createdAt +
                ", status='" + status + "', items=" + items + '}';
    }

}
