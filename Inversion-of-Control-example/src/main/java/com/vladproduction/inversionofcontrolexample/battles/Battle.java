package com.vladproduction.inversionofcontrolexample.battles;

import java.util.Objects;

class Battle{

    private String name;
    private String winner;
    private String date;
    private String place;

    public Battle(String name, String winner, String date, String place) {
        this.name = name;
        this.winner = winner;
        this.date = date;
        this.place = place;
    }

    public Battle() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Battle battle = (Battle) object;
        return Objects.equals(name, battle.name) && Objects.equals(winner, battle.winner) && Objects.equals(date, battle.date) && Objects.equals(place, battle.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, winner, date, place);
    }

    @Override
    public String toString() {
        return "Battle{" +
                "name='" + name + '\'' +
                ", winner='" + winner + '\'' +
                ", date='" + date + '\'' +
                ", place='" + place + '\'' +
                '}';
    }


}