package main.java.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.Setting;

public class Verify {
    public static int getUserId(String userId, String name) {
        int userIdValue = 0;
        String query = "SELECT id FROM user WHERE userId = ? AND name = ?;";
        try (Connection conn = Setting.conMySql();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, userId);
            pstmt.setString(2, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    userIdValue = rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userIdValue;
    }

    public static int getBookId(String bookId) {
        int bookIdValue = 0;
        String query = "SELECT id FROM book WHERE bookId = ? AND status = 0;";
        try (Connection conn = Setting.conMySql();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, bookId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    bookIdValue = rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookIdValue;
    }
}
