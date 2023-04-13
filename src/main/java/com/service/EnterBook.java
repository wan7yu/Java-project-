package LibMangeSystem.src.main.java.com.service;

import java.sql.*;
import java.time.*;

public class EnterBook {
    public boolean entry(String bookTitle,String author,String press) {
        // 这里是连接数据库的操作
        String[] mysqlset = main.java.Setting.getMySql();
        String jdbcDriver = mysqlset[0];
        String dbUrl = mysqlset[1];
        String user = mysqlset[2];
        String password = mysqlset[3];
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(jdbcDriver);
            System.out.println("连接数据库...");

            conn = DriverManager.getConnection(dbUrl,user,password);
            int status = 0;
            Date curTime = null;
            String sql = "INSERT INTO book(bookTitle,author,press,status,curTime) Values(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,bookTitle);
            pstmt.setString(2,author);
            pstmt.setString(3,press);
            pstmt.setInt(4,status);
            pstmt.setDate(5,curTime);

            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            try {
                if (pstmt!=null)
                    pstmt.close();
                if (conn!=null)
                    conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return true;
    }

}
