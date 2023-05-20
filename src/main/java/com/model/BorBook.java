package main.java.com.model;

import java.time.*;

public class BorBook {
    private int bookId;
    private int stuId;
    private LocalDateTime curTime;

    // set方法
    public void setBorBook(int bookId, int stuId, LocalDateTime curTime) {
        this.bookId = bookId;
        this.stuId = stuId;
        this.curTime = curTime;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public void setCurTime(LocalDateTime curTime) {
        this.curTime = curTime;
    }

    // get方法
    public int getBookId() {
        return this.bookId;
    }

    public int getStuId() {
        return this.stuId;
    }

    public LocalDateTime getCuTime() {
        return this.curTime;
    }

    public LocalDateTime getCurTime() {
        return this.curTime;
    }
}
