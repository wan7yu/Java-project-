package main.java.com.model;

import java.time.*;

public class Student {
    private int stuId;
    private String name;
    private int borNum;
    private LocalDateTime borTime;
    private LocalDateTime endTime;

    // set方法
    public void setBook(int stuId, String name, int borNum, LocalDateTime borTime, LocalDateTime endTime) {
        this.stuId = stuId;
        this.name = name;
        this.borNum = borNum;
        this.borTime = borTime;
        this.endTime = endTime;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBorNUm(int borNum) {
        this.borNum = borNum;
    }

    public void setBorTime(LocalDateTime borTime) {
        this.borTime = borTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    // get方法
    public int getStuId() {
        return this.stuId;
    }

    public String getName() {
        return this.name;
    }

    public int getBorNum() {
        return this.borNum;
    }

    public LocalDateTime getBorTime() {
        return this.borTime;
    }

    public LocalDateTime getBorEndTime() {
        return this.endTime;
    }
}