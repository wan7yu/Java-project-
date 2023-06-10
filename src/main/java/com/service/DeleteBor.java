package main.java.com.service;

import java.sql.*;

import main.java.Setting;

public class DeleteBor {

    public Boolean deleteBor(String userId, String booktitle) {

        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3 = null;
        try {
            // 连接数据库
            conn = Setting.conMySql();
            // 开启事务
            conn.setAutoCommit(false);

            // 第一个 SQL 语句
            String deleteBor = "DELETE FROM borBook WHERE bookId = (SELECT id FROM book WHERE bookTitle = ?);";
            pstmt1 = conn.prepareStatement(deleteBor);
            pstmt1.setString(1, booktitle);
            // 执行第一个 SQL 语句
            int result1 = pstmt1.executeUpdate();

            // 检查第一个 SQL 语句的执行结果
            if (result1 == Statement.EXECUTE_FAILED) {
                System.out.print(booktitle);
                // SQL 语句执行失败，立即回滚事务并返回 false
                conn.rollback();
                return false;
            }

            // 第二个 SQL 语句
            String updateUser = "UPDATE user SET borNum = borNum - 1 WHERE userId = ?;";
            pstmt2 = conn.prepareStatement(updateUser);
            pstmt2.setString(1, userId);
            // 执行第二个 SQL 语句
            int results2 = pstmt2.executeUpdate();

            if (results2 == Statement.EXECUTE_FAILED) {
                System.out.print(userId);
                // SQL 语句执行失败，立即回滚事务并返回 false
                conn.rollback();
                return false;
            }

            // 第三个 SQL 语句
            String updatebook = "UPDATE book SET status = 0, userId = null, curTime = null WHERE bookTitle = ?;";
            pstmt3 = conn.prepareStatement(updatebook);
            pstmt3.setString(1, booktitle);
            // 执行第三个 SQL 语句
            int results3 = pstmt3.executeUpdate();

            if (results3 == Statement.EXECUTE_FAILED) {
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
            if (pstmt1 != null) {
                try {
                    pstmt1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt2 != null) {
                try {
                    pstmt2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt3 != null) {
                try {
                    pstmt3.close();
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
