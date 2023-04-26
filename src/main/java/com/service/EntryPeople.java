package LibMangeSystem.src.main.java.com.service;

import java.sql.*;
import java.time.*;

import main.java.Setting;

public class EntryPeople {
    private Connection conn = Setting.conMySql();

    public Boolean entryBorBook(int bookId, int stuId, LocalDateTime curTime) {
        PreparedStatement pstmt = null;
        int rows = 0;
        try {
            String insertSql = "INSERT INTO student(bookId,stuId,curTime) VALUES(?,?,?)";
            // 开始录入
            pstmt = conn.prepareStatement(insertSql);
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

    public Boolean entryStundet(int stuId, String name, int borNum, LocalDateTime borTime,
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
}
