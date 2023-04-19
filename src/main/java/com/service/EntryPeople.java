package main.java.com.service;

import java.sql.*;
import java.time.*;

import main.java.Setting;

public class EntryPeople {
    private static Connection conn = Setting.conMySql();

    public static Boolean entryBorBook(int bookId, int stuId, LocalDateTime curTime) {
        PreparedStatement pstmt = null;
        int rows = 0;
        try {
            String sql = "INSERT INTO student(bookId,stuId,curTime) VALUES(?,?,?)";
            // 开始录入
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bookId);
            pstmt.setInt(2, stuId);
            pstmt.setObject(3, curTime);
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

    public static Boolean entryStundet(int stuId, String name, int borNum, LocalDateTime borTime,
            LocalDateTime endTime) {
        PreparedStatement pstmt = null;
        int rows = 0;
        try {
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
        }
        // 判断是否录入成功
        if (rows > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean query() {
        ResultSet students = null;
        ResultSet borBooks = null;
        ResultSet bookTitles = null;
        int[] books = null;
        try {
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
        }
        return true;
    }
}
