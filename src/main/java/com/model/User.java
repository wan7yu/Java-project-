package main.java.com.model;

public class User {
    private int userId;
    private String password;
    private String name;
    private int borNum;

    // set方法
    public void setBook(int userId, String password, String name, int borNum) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.borNum = borNum;
    }

    public void setStuId(int userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBorNUm(int borNum) {
        this.borNum = borNum;
    }

    // get方法
    public int getStuId() {
        return this.userId;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.name;
    }

    public int getBorNum() {
        return this.borNum;
    }
}