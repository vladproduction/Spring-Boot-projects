package com.vladproduction.connection2db.entity.bike;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Created by vladproduction on 10-Apr-24
 */
@Entity
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bike_id;
    private String bike_model;
    private String bike_color;
    private double bike_price;

    public Long getBike_id() {
        return bike_id;
    }

    public void setBike_id(Long bike_id) {
        this.bike_id = bike_id;
    }

    public String getBike_color() {
        return bike_color;
    }

    public void setBike_color(String bike_color) {
        this.bike_color = bike_color;
    }

    public double getBike_price() {
        return bike_price;
    }

    public void setBike_price(double bike_price) {
        this.bike_price = bike_price;
    }

    public String getBike_model() {
        return bike_model;
    }

    public void setBike_model(String bike_model) {
        this.bike_model = bike_model;
    }
}
