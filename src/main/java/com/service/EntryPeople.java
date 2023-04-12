package LibMangeSystem.src.main.java.com.service;

import java.sql.*;
import java.time.*;
import LibMangeSystem.src.mian.java.Setting;

public class EntryPeople {
    public void entry() {
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
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(dbUrl, user, password);

            // 执行查询
            // 实例化Statement对象...
            Statement stmt = conn.createStatement();
            int stuId = 1;
            String name = "王烨";
            int borNum = 0;
            LocalTime nowTime = LocalTime.now();
            LocalDate nowDate = LocalDate.now();
            LocalDate endDate = nowDate.plusDays(120);
            LocalDateTime borTime = nowTime.atDate(nowDate);
            LocalDateTime endTime = nowTime.atDate(endDate);
            String sql = "INSERT INTO student(stuId,name,borNum,borTime,endTime) VALUES(?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, stuId);
            pstmt.setString(2, name);
            pstmt.setInt(3, borNum);
            pstmt.setString(2, borTime);
            pstmt.setString(2, endTime);
            int rows = pstmt.executeUpdate();
            System.out.println("插入了" + rows + "数据行");
        } catch (SQLException e) {
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
        }
    }
}
