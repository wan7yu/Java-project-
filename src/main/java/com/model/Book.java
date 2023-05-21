package main.java.com.model;

import java.sql.Date;
import java.time.LocalDateTime;

public class Book {
    private int bookId;
    private String bookTitle;
    private String author;
    private String press;
    private int status;
    private LocalDateTime curTime;
    private int curStuId;

    // set方法
    public void setBook(int bookId, String bookTitle, String author, String press, int status, LocalDateTime curTime,
            int curStuId) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.press = press;
        this.status = status;
        this.curTime = curTime;
        this.curStuId = curStuId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPress(String press) {
        this.press = press;

    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCurTime(LocalDateTime curTime) {
        this.curTime = curTime;
    }

    public void setCurStuId(int curStuId) {
        this.curStuId = curStuId;
    }

    // get方法
    public int getBookId() {
        return this.bookId;
    }

    public String getBookTitle() {
        return this.bookTitle;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPress() {
        return this.press;
    }

    public String getStatus() {
        return String.valueOf(this.status);
    }

    public String getBorTime() {
        return String.valueOf(this.curTime);
    }

    public int getCurStuId() {
        return this.curStuId;
    }

    public int getCurStuId() {
        return this.curStuId;
    }
}