package com.vladproduction.inversionofcontrolexample.clothing;

import java.util.Objects;

class Cloth {
    private String type;
    private String color;
    private String style;
    private String brand;

    public Cloth(String type, String color, String style, String brand) {
        this.type = type;
        this.color = color;
        this.style = style;
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Cloth cloth = (Cloth) object;
        return Objects.equals(type, cloth.type) && Objects.equals(color, cloth.color) && Objects.equals(style, cloth.style) && Objects.equals(brand, cloth.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color, style, brand);
    }

    @Override
    public String toString() {
        return "Cloth{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", style='" + style + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}