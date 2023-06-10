package main.java.com.service;

import java.sql.*;

import main.java.Setting;
import main.java.com.model.*;

public class EnterBor {

    public static Boolean enterBor(BorBook borBook, String bookId) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3 = null;
        try {
            // 连接数据库
            conn = Setting.conMySql();
            // 开启事务
            conn.setAutoCommit(false);

            // 第一个sql语句
            String insertBor = "INSERT INTO borBook(userId,bookId,curTime,endTime) VALUES(?,?,?,?)";
            pstmt1 = conn.prepareStatement(insertBor);
            pstmt1.setInt(1, borBook.getUserId());
            pstmt1.setInt(2, borBook.getBookId());
            pstmt1.setObject(3, borBook.getCurTime());
            pstmt1.setObject(4, borBook.getEndTime());
            // 执行第一个 SQL 语句
            int result1 = pstmt1.executeUpdate();

            // 检查第一个 SQL 语句的执行结果
            if (result1 == Statement.EXECUTE_FAILED) {
                // SQL 语句执行失败，立即回滚事务并返回 false
                conn.rollback();
                return false;
            }
            // 第二个sql语句
            String updateBook = "UPDATE book set status=1,curTime = ?,userId = (SELECT userId FROM user WHERE id = ? ) WHERE bookId = ?";
            pstmt2 = conn.prepareStatement(updateBook);
            pstmt2.setObject(1, borBook.getCurTime());
            pstmt2.setObject(2, borBook.getUserId());
            pstmt2.setString(3, bookId);
            // 执行第二个 SQL 语句
            int results2 = pstmt2.executeUpdate();

            if (results2 == Statement.EXECUTE_FAILED) {
                // SQL 语句执行失败，立即回滚事务并返回 false
                conn.rollback();
                return false;
            }

            // 第三个sql语句
            String updateUser = "UPDATE user set borNum = borNum + 1 WHERE id = ?";
            pstmt3 = conn.prepareStatement(updateUser);
            pstmt3.setObject(1, borBook.getUserId());
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
