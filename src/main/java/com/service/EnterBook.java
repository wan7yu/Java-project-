package LibMangeSystem.src.main.java.com.service;

import java.sql.*;

import LibMangeSystem.src.main.java.Setting;
import LibMangeSystem.src.main.java.com.model.Book;
import LibMangeSystem.src.main.java.com.model.BorBook;

public class EnterBook {
    public void enterBook() {
        // 这里是连接数据库的操作
        String[] mysqlset = Setting.getMySql();
        String jdbcDriver = mysqlset[0];
        String dbUrl = mysqlset[1];
        String user = mysqlset[2];
        String password = mysqlset[3];
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(jdbcDriver);
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(dbUrl, user, password);

            Statement stmt = conn.createStatement();
            String title = null;
            String author = null;
            String press = null;
            int status = 0;
            Date curTime = null;
            String sql = "INSERT INTO book(title,author,press,status,borTime) Values(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, press);
            pstmt.setInt(4, status);
            pstmt.setDate(5, curTime);

            int rows = pstmt.executeUpdate();
            System.out.println("插入了" + rows + "数据行");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
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
