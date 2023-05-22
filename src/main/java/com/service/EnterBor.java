package main.java.com.service;

import java.sql.*;
import java.time.*;

import main.java.Setting;
import main.java.com.model.*;
import main.java.util.*;

public class EnterBor {
    private static Connection conn = Setting.conMySql();

    public static Boolean enterBor(int userId, String name, int bookId) {
        LocalDateTime curTime = LocalDateTime.now();
        LocalDateTime endTime = curTime.plusDays(120);
        BorBook borBook = new BorBook();
        if (Verify.isStudent(userId)) {
            return false;
        }
        if (Verify.isBookId(bookId)) {
            return false;
        }
        borBook.setBorBook(userId, bookId, curTime, endTime);
        PreparedStatement pstmt = null;
        int rows = 0;
        try {
            String sql = "INSERT INTO borBook(userId,bookId,curTime) VALUES(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, bookId);
            pstmt.setObject(3, curTime);
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
                pstmt.setObject(1, curTime);
                pstmt.setInt(2, bookId);
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
        new EnterBor().enterBor(1, "null", 0);
    }
}
