package LibMangeSystem.src.main.java.com.service;

import java.sql.*;
import java.time.*;

import main.java.com.model.BorBook;
import main.java.Setting;

public class EntryPeople {
    private Connection conn = Setting.conMySql();

    public Boolean entryBorBook(BorBook borBook) {
        PreparedStatement pstmt = null;
        int rows = 0;
        try {
            String insertSql = "INSERT INTO student(bookId,stuId,curTime) VALUES(?,?,?)";
            // 开始录入
            pstmt = conn.prepareStatement(insertSql);
            pstmt.setInt(1, borBook.getBookId());
            pstmt.setInt(2, borBook.getStuId());
            pstmt.setObject(3, borBook.getCurTime());
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

    public Boolean entryStundet(Student student) {
        PreparedStatement pstmt = null;
        int rows = 0;
        try {
            String sql = "INSERT INTO student(stuId,name,borNum,borTime,endTime) VALUES(?,?,?,?,?)";
            // 开始录入
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, student.getStuId());
            pstmt.setString(2, student.getName());
            pstmt.setInt(3, student.getBorNum());
            pstmt.setObject(4, student.getBorTime());
            pstmt.setObject(5, student.getEndTime());
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
