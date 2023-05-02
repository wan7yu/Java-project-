package main.java.com.service;

import java.sql.*;
import java.time.*;

import main.java.Setting;

public class EntryPeople {
    private String[] mysqlset = Setting.getMySql();
    private String jdbcDriver = mysqlset[0];
    private String dbUrl = mysqlset[1];
    private String user = mysqlset[2];
    private String password = mysqlset[3];

    public Boolean entryBorBook() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int rows = 0;
        try {
            // 注册 JDBC 驱动
            Class.forName(jdbcDriver);
            // 打开链接
            conn = DriverManager.getConnection(dbUrl, user, password);
            int stuId = 1;
            int bookId = 1;
            String sql = "INSERT INTO student(bookId,stuId) VALUES(?,?)";
            // 开始录入
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bookId);
            pstmt.setInt(1, stuId);
            rows = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 判断是否录入成功
        if (rows > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean entryStundet() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int rows = 0;
        try {
            // 注册 JDBC 驱动
            Class.forName(jdbcDriver);
            // 打开链接
            conn = DriverManager.getConnection(dbUrl, user, password);

            // 执行查询
            // 实例化Statement对象...
            int stuId = 1;
            String name = "王朋";
            int borNum = 0;
            LocalTime nowTime = LocalTime.now();
            LocalDate nowDate = LocalDate.now();
            LocalDate endDate = nowDate.plusDays(120);
            LocalDateTime borTime = nowTime.atDate(nowDate);
            LocalDateTime endTime = nowTime.atDate(endDate);
            String sql = "INSERT INTO student(stuId,name,borNum,borTime,endTime) VALUES(?,?,?,?,?)";
            // 开始录入
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, stuId);
            pstmt.setString(2, name);
            pstmt.setInt(3, borNum);
            pstmt.setObject(4, borTime);
            pstmt.setObject(5, endTime);
            rows = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 判断是否录入成功
        if (rows > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean query() {
        Connection conn = null;
        ResultSet students = null;
        ResultSet borBooks = null;
        ResultSet bookTitles = null;
        int[] books = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(jdbcDriver);
            // 打开链接
            conn = DriverManager.getConnection(dbUrl, user, password);
            Statement sql = conn.createStatement();
            students = sql.executeQuery("SELECT stuId,name,borNum,borTime,endTime FROM student;");
            while (students.next()) {
                int stuId = students.getInt(1);
                borBooks = sql.executeQuery("SELECT bookId FROM borBook whata stuId == " + stuId + ";");
                int num = 0;
                while (borBooks.next()) {
                    int bookId = borBooks.getInt(1);
                    books[num] = bookId;
                    num++;
                }
                borBooks.close();
                for (int id : books) {
                    bookTitles = sql.executeQuery("SELECT bookTitle FROM book whata id == " + id + ";");
                    while (bookTitles.next()) {
                        String bookTitle = bookTitles.getString(1);
                    }
                    bookTitles.close();
                }
                String name = students.getString(2);
                int borNum = students.getInt(3);
                Date borTime = students.getDate(4);
                Date endTime = students.getDate(5);
            }
            students.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
