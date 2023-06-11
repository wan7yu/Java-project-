package main.java.com.service;

import java.sql.*;

import main.java.Setting;

public class DeleteUser {

    public Boolean deleteUser(String userId) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 连接数据库
            conn = Setting.conMySql();
            // 开启事务
            conn.setAutoCommit(false);

            // 第一个 SQL 语句
            String deleteUser = "DELETE FROM user WHERE userId = ?;";
            pstmt = conn.prepareStatement(deleteUser);
            pstmt.setString(1, userId);
            // 执行第一个 SQL 语句
            int result1 = pstmt.executeUpdate();

            // 检查第一个 SQL 语句的执行结果
            if (result1 == Statement.EXECUTE_FAILED) {
                System.out.print(userId);
                // SQL 语句执行失败，立即回滚事务并返回 false
                conn.rollback();
                return false;
            }

            // 提交事务
            conn.commit();

            return true;
        } catch (SQLException e) {
            // 发生异常时回滚事务
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
            return false;
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    // 恢复自动提交模式
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
