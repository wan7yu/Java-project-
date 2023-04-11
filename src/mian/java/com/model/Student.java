package mian.java.com.model;

public class Student {
    private int stuId;
    private String name;
    private int borNum;
    private String borTime;
    private String endTime;

    public void setBook(int stuId, String name, int borNum, String borTime, String endTime) {
        this.stuId = stuId;
        this.name = name;
        this.borNum = borNum;
        this.borTime = borTime;
        this.endTime = endTime;
    }
}