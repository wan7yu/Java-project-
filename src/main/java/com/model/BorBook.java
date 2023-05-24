package main.java.com.model;

import java.time.*;

public class BorBook {
    private int bookId;
    private int userId;
    private LocalDateTime curTime;
    private LocalDateTime endTime;

    // set方法
    public void setBorBook(int bookId, int userId, LocalDateTime curTime, LocalDateTime endTime) {
        this.bookId = bookId;
        this.userId = userId;
        this.curTime = curTime;
        this.endTime = endTime;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCurTime(LocalDateTime curTime) {
        this.curTime = curTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    // get方法
    public int getBookId() {
        return this.bookId;
    }

    public int getUserId() {
        return this.userId;
    }

    public LocalDateTime getCurTime() {
        return this.curTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }
}
