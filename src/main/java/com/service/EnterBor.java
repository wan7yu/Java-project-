package main.java.com.service;

import java.sql.*;
import java.time.*;

import main.java.Setting;
import main.java.com.model.*;
import main.java.util.*;

public class EnterBor {
    private static Connection conn = Setting.conMySql();

    public static Boolean enterBor(String userId, String name, String bookId) {
        LocalDateTime curTime = LocalDateTime.now();
        LocalDateTime endTime = curTime.plusDays(120);
        BorBook borBook = new BorBook();
        int user = Verify.isStudent(userId, name);

        if (user == 0) {
            return false;
        }
        int book = Verify.isBookId(bookId);

        if (book == 0) {
            return false;
        }
        borBook.setBorBook(user, book, curTime, endTime);
        PreparedStatement pstmt = null;
        int rows = 0;
        try {
            String sql = "INSERT INTO borBook(userId,bookId,curTime) VALUES(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, borBook.getUserId());
            pstmt.setInt(2, borBook.getBookId());
            pstmt.setObject(3, borBook.getCurTime());
            rows = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rows > 0) {
            rows = 0;
            try {
                String sql = "UPDATE book set curTime = ? where bookId = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setObject(1, borBook.getCurTime());
                pstmt.setString(2, bookId);
                rows = pstmt.executeUpdate();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (rows > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        enterBor("2021764101", "杨丹丹", "010001");
    }
}
