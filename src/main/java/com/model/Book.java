package LibMangeSystem.src.main.java.com.model;

import java.time.*;

public class Book {
    private String bookTitle;
    private String author;
    private String press;
    private int status;
    private LocalDateTime curTime;

    public void setBook(String bookTitle, String author, String press, int status, LocalDateTime curTime) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.press = press;
        this.status = status;
        this.curTime = curTime;
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

    public int getStatus() {
        return this.status;
    }

    public LocalDateTime getBorTime() {
        return this.curTime;
    }
}