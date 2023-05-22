package main.java.util;

import java.sql.*;

import main.java.Setting;

public class Verify {
    private static Connection conn = Setting.conMySql();
    private static Boolean isBoolean;

    public static Boolean isStudent(int userId) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT id FROM user WHERE userId = ?");
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                isBoolean = true;
            } else {
                isBoolean = false;
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isBoolean;
    }

    public static Boolean isBookId(int bookId) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT id FROM book WHERE bookId = ?");
            pstmt.setInt(1, bookId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                isBoolean = true;
            } else {
                isBoolean = false;
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isBoolean;
    }
}
