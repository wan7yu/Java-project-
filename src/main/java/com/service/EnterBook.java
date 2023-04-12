package LibMangeSystem.src.main.java.com.service;
<<<<<<< HEAD
import java.sql.*;
import LibMangeSystem.src.main.java.com.model.Book;

public abstract class EnterBook {
    public Book[] createBook(){
        String[] title = {"活着","围城", "红楼梦", "孙子兵法", "三体",
                "茶花女", "活着的意义", "百年孤独", "平凡的世界", "霍乱时期的爱情"};
        String[] author = {"余华","钱钟书","曹雪芹","孙武","刘慈欣",
                "小仲马", "维克多·弗兰克", "加西亚·马尔克斯","路遥","加西亚·马尔克斯"};
        String[] press = {"作家出版社","人民文学出版社","人民文学出版社","中华书局","重庆出版社",
                "人民文学出版社","江苏人民出版社","上海译文出版社","人民文学出版社","南海出版公司"};
        int[] status = {1,0,0,0,1,0,1,0,1,1};
        String[] date = {"2021-10-24",null,null,null,"2021-9-10",
                null,"2022-6-2",null,"2022-3-14","2021-4-14"};
        Book[] bookArray = new Book[10];
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setBook(title[i],author[i],press[i],status[i],date[i]);
            bookArray[i] = book;
        }
        return bookArray;
    }
    public void enterBook(){
        // 这里是连接数据库的操作
        Book[] bookArray = createBook();


=======

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
            conn = DriverManager.getConnection(dbUrl,user,password);

            Statement stmt = conn.createStatement();
            String title = null;
            String author = null;
            String press = null;
            int status = 0;
            Date curTime = null;
            String sql = "INSERT INTO book(title,author,press,status,borTime) Values(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,title);
            pstmt.setString(2,author);
            pstmt.setString(3,press);
            pstmt.setInt(4,status);
            pstmt.setDate(5,curTime);

            int rows = pstmt.executeUpdate();
            System.out.println("插入了"+rows+"数据行");
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
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
>>>>>>> 560f7bf8e5293493905bd1ce9d974f9d75a638de
    }

}
