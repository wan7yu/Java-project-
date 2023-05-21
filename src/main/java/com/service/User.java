package main.java.com.service;

import java.time.LocalDateTime;

public class User {
    private String username;
    private String password;
    private LocalDateTime createTime;

    public void setUserName(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }
}
