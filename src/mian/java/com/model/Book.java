package mian.java.com.model;

public class Book {
    private String bookTitle;
    private String autor;
    private String press;
    private int status;
    private String borTime;

    public void setBook(String bookTitle, String autor, String press, int status, String borTime) {
        this.bookTitle = bookTitle;
        this.autor = autor;
        this.press = press;
        this.status = status;
        this.borTime = borTime;
    }
}
