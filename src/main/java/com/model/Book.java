package LibMangeSystem.src.main.java.com.model;

public class Book {
    private String bookTitle;
    private String author;
    private String press;
    private int status;
    private String borTime;

    public void setBook(String bookTitle, String author, String press, int status, String borTime) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.press = press;
        this.status = status;
        this.borTime = borTime;
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

    public String getBorTime() {
        return this.borTime;
    }
}