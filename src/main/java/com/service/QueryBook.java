package LibMangeSystem.src.main.java.com.service;

import java.sql.*;

public class QueryBook {
    public boolean query(){
        String[] mysqlset = main.java.Setting.getMySql();
        String jdbcDriver = mysqlset[0];
        String dbUrl = mysqlset[1];
        String user = mysqlset[2];
        String password = mysqlset[3];
        Connection  conn = null;
        Statement stmt = null;
        ResultSet rs;
        try {
            Class.forName(jdbcDriver);
            System.out.println("连接数据库...");

            conn = DriverManager.getConnection(dbUrl,user,password);
            stmt = conn.createStatement();
            String sql = "select * from book";

            rs = stmt.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("bookTitle");
                String author = rs.getString("author");
                String press = rs.getString("press");
                int status = rs.getInt("status");
                Date curTime = rs.getDate("curTime");

                System.out.println("id:"+id+"\t"+"书名:"+title+"\t"+"作者:"+author+"\t"+
                        "出版社:"+press+"\t"+"借阅状态:"+status+"\t"+"借阅时间:"+curTime);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (conn!=null)
                    conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return true;
    }
}
