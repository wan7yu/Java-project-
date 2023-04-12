package LibMangeSystem.src.main.java.com.model;

public class Book {
    private String bookTitle;
    private String author;
    private String press;
    private int status;
    private String borTime;

    public void setBook(String bookTitle, String autor, String press, int status, String borTime) {
        this.bookTitle = bookTitle;
        this.author = autor;
        this.press = press;
        this.status = status;
        this.borTime = borTime;
    }
}
