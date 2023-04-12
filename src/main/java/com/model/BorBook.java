package LibMangeSystem.src.main.java.com.model;

import java.time.*;

public class BorBook {
    private int bookId;
    private int stuId;
    private LocalDateTime curTime;

    public void setBorBook(int bookId, int stuId, LocalDateTime curTime) {
        this.bookId = bookId;
        this.stuId = stuId;
        this.curTime = curTime;
    }

    public int getBookId() {
        return this.bookId;
    }

    public int getStuId() {
        return this.stuId;
    }

    public LocalDateTime getCuTime() {
        return this.curTime;
    }
}
