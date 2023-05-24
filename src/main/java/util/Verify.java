package main.java.util;

import java.sql.*;

import main.java.Setting;

public class Verify {
    private static Connection conn = Setting.conMySql();
    private static int object;

    public static int isStudent(String userId, String name) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT id FROM user WHERE userId = ? AND name = ?;");
            pstmt.setString(1, userId);
            pstmt.setString(2, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                object = rs.getInt(1);
                System.out.println(object);
            } else {
                object = 0;
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static int isBookId(String bookId) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT id FROM book WHERE bookId = ?;");
            pstmt.setString(1, bookId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                object = rs.getInt(1);
            } else {
                object = 0;
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return object;
    }
}
