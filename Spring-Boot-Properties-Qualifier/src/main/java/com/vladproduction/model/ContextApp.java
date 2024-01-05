package com.vladproduction.model;


import java.util.Objects;

public class ContextApp {
    private int port;
    private String profile;

    public ContextApp() {
    }

    public ContextApp(int port, String profile) {
        this.port = port;
        this.profile = profile;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ContextApp that = (ContextApp) object;
        return port == that.port && Objects.equals(profile, that.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(port, profile);
    }

    @Override
    public String toString() {
        return "ContextApp{" +
                "port=" + port +
                ", profile='" + profile + '\'' +
                '}';
    }
}
