package main.java.com.service;

import java.sql.*;

import main.java.Setting;
import main.java.com.model.*;

public class EnterBor {
    private static Connection conn = Setting.conMySql();

    public static Boolean enterBor(BorBook borBook, String bookId) {
        PreparedStatement pstmt = null;
        int rows = 0;
        try {
            String sql = "INSERT INTO borBook(userId,bookId,curTime,endTime) VALUES(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, borBook.getUserId());
            pstmt.setInt(2, borBook.getBookId());
            pstmt.setObject(3, borBook.getCurTime());
            pstmt.setObject(4, borBook.getEndTime());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rows > 0) {
            rows = 0;
            try {
                String updateBook = "UPDATE book set status=1,curTime = ? WHERE bookId = ?";
                pstmt = conn.prepareStatement(updateBook);
                pstmt.setObject(1, borBook.getCurTime());
                pstmt.setString(2, bookId);
                rows = pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (rows > 0) {
                rows = 0;
                try {
                    String updateUser = "UPDATE user set borNum = borNum + 1 WHERE id = ?";
                    pstmt = conn.prepareStatement(updateUser);
                    pstmt.setObject(1, borBook.getUserId());
                    rows = pstmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (rows > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
