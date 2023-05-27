package main.java.com.service;

import java.sql.*;

import main.java.com.model.User;
import main.java.Setting;

public class EntryUser {
    private static Connection conn = Setting.conMySql();

    public static Boolean entryStundet(User user) {
        PreparedStatement pstmt = null;
        int rows = 0;
        try {
            String sql = "INSERT INTO user(userId,password,name,borNum) VALUES(?,?,?,?)";
            // 开始录入
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setInt(4, user.getBorNum());
            rows = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 判断是否录入成功
        if (rows > 0) {
            return true;
        } else {
            return false;
        }
    }
}
