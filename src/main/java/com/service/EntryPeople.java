package main.java.com.service;

import java.sql.*;
import java.time.*;

import main.java.Setting;

public class EntryPeople {
    public Boolean entry() {
        String[] mysqlset = Setting.getMySql();
        String jdbcDriver = mysqlset[0];
        String dbUrl = mysqlset[1];
        String user = mysqlset[2];
        String password = mysqlset[3];
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(jdbcDriver);
            // 打开链接
            conn = DriverManager.getConnection(dbUrl, user, password);

            // 执行查询
            // 实例化Statement对象...
            int stuId = 1;
            String name = "王烨";
            int borNum = 0;
            LocalTime nowTime = LocalTime.now();
            LocalDate nowDate = LocalDate.now();
            LocalDate endDate = nowDate.plusDays(120);
            LocalDateTime borTime = nowTime.atDate(nowDate);
            LocalDateTime endTime = nowTime.atDate(endDate);
            String sql = "INSERT INTO student(stuId,name,borNum,borTime,endTime) VALUES(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, stuId);
            pstmt.setString(2, name);
            pstmt.setInt(3, borNum);
            pstmt.setObject(4, borTime);
            pstmt.setObject(5, endTime);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭数据库连接
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }
    }
}
