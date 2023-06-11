package main.java.com.service;

import java.sql.*;

import main.java.Setting;
import main.java.com.model.*;

public class EnterBook {

    public static boolean entryBook(Book book) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 连接数据库
            conn = Setting.conMySql();
            // 开启事务
            conn.setAutoCommit(false);

            // 第一个sql语句
            String insertBook = "INSERT INTO book(bookId,bookTitle,author,press,status,curTime,userId) VALUES(?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(insertBook);
            pstmt.setString(1, book.getBookId());
            pstmt.setString(2, book.getBookTitle());
            pstmt.setString(3, book.getAuthor());
            pstmt.setString(4, book.getPress());
            pstmt.setInt(5, book.getStatus());
            pstmt.setObject(6, book.getCurTime());
            pstmt.setString(7, book.getUserId());
            // 执行第一个 SQL 语句
            int result1 = pstmt.executeUpdate();

            // 检查第一个 SQL 语句的执行结果
            if (result1 == Statement.EXECUTE_FAILED) {
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
