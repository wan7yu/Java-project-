package main.java.com.service;

import main.java.Setting;
import main.java.com.model.Book;

import java.sql.*;
import java.time.LocalDateTime;

public class UpdateBook {

    public static boolean modifyBook(Book book) {
        String bookId = book.getBookId();
        String bookTitle = book.getBookTitle();
        String author = book.getAuthor();
        String press = book.getPress();
        int status = Integer.parseInt(book.getStatus());
        LocalDateTime curTime = book.getCurTime();
        String userId = book.getUserId();

        Connection conn = null;
        Timestamp timestamp;
        if (curTime == null) {
            timestamp = null;
        } else {
            timestamp = Timestamp.valueOf(curTime);
        }
        int rows = 0;
        try {
            // 连接数据库
            conn = Setting.conMySql();
            PreparedStatement ptmt = null;
            String sql = "update book set bookId = ?, bookTitle = ?, author = ?, " +
                    "press = ?, status = ?, curTime = ?, userId = ? " +
                    " where bookId = ? ";
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, bookId);
            ptmt.setString(2, bookTitle);
            ptmt.setString(3, author);
            ptmt.setString(4, press);
            ptmt.setInt(5, status);
            ptmt.setTimestamp(6, timestamp);
            ptmt.setString(7, userId);
            ptmt.setString(8, bookId);
            rows = ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows > 0;
    }
}
