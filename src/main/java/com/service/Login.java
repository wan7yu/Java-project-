package main.java.com.service;

import java.sql.*;

import main.java.Setting;

public class Login {
    public static Boolean login(String userId, int password) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 连接数据库
            conn = Setting.conMySql();
            String insertUser = "SELECT id FROM user WHERE userId = ? AND password = ? ;";
            // 准备查询语句
            pstmt = conn.prepareStatement(insertUser);
            pstmt.setString(1, userId);
            pstmt.setInt(2, password);
            // 执行查询语句
            rs = pstmt.executeQuery();

            // 检查查询结果
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
