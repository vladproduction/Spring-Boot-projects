package com.vladproduction.controller;

import java.util.Objects;

public class MyCronTask {

    private String task;

    private String cron;

    public MyCronTask() {
    }

    public MyCronTask(String task, String cron) {
        this.task = task;
        this.cron = cron;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        MyCronTask that = (MyCronTask) object;
        return Objects.equals(task, that.task) && Objects.equals(cron, that.cron);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task, cron);
    }

    @Override
    public String toString() {
        return "MyCronTask{" +
                "task='" + task + '\'' +
                ", cron='" + cron + '\'' +
                '}';
    }
}
