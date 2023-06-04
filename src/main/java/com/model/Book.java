package main.java.com.model;

import java.time.LocalDateTime;

public class Book {
    private String bookId;
    private String bookTitle;
    private String author;
    private String press;
    private int status;
    private LocalDateTime curTime;
    private String userId;

    // set方法
    public void setBook(String bookId, String bookTitle, String author, String press, int status, LocalDateTime curTime,
            String userId) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.press = press;
        this.status = status;
        this.curTime = curTime;
        this.userId = userId;
    }

    public void setBookId(String bookId) {
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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // get方法
    public String getBookId() {
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

    public LocalDateTime getCurTime() {
        return this.curTime;
    }

    public String getUserId() {
        return this.userId;
    }
}
