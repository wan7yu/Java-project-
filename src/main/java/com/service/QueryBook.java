package main.java.com.service;

import main.java.com.model.Book;
import java.util.Vector;

import java.sql.*;

public class QueryBook {
    private static Connection conn = main.java.Setting.conMySql();
    public static Book book;

    // 查询所有图书
    public static Vector<Vector<String>> queryAll() {
        Vector<Vector<String>> dataList = new Vector<>();
        ResultSet resultset = null;
        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT bookId,bookTitle,author,press,status,curTime,userId FROM book;";
            resultset = statement.executeQuery(sql);
            // 判断是否存在查询结果
            if (!resultset.next()) {
                return dataList;
            }
            do {
                String bookId = resultset.getString(1);
                String bookTitle = resultset.getString(2);
                String author = resultset.getString(3);
                String press = resultset.getString(4);
                int status = resultset.getInt(5);
                Timestamp curTime = resultset.getTimestamp(6);
                String userId = resultset.getString(7);
                String userCurTime = new String();
                if (curTime != null) {
                    userCurTime = curTime.toString();
                }
                String bookStatus = new String();
                if (status == 0) {
                    bookStatus = "空闲";
                } else if (status == 1) {
                    bookStatus = "已借";
                }
                Vector<String> data = new Vector<>();
                data.add(bookId);
                data.add(bookTitle);
                data.add(author);
                data.add(press);
                data.add(bookStatus);
                data.add(userId);
                data.add(userCurTime);
                dataList.add(data);
            } while (resultset.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    // // 查询指定书的方法
    // public static Book queryDefine(String TemBookTitle, String TemAuthor, String
    // TemPress) throws SQLException {
    // if (!TemBookTitle.isEmpty()) {
    // StringBuilder sb = new StringBuilder("SELECT
    // id,bookTitle,author,press,status,curtime FROM book");
    // sb.append(" WHERE bookTitle like \"%");
    // sb.append(TemBookTitle);
    // ResultQuery(sb);
    // }
    // if (!TemAuthor.isEmpty()) {

    // StringBuilder sb = new StringBuilder("SELECT
    // id,bookTitle,author,press,status,curtime From book");
    // sb.append(" WHERE author like \"%");
    // sb.append(TemAuthor);
    // ResultQuery(sb);
    // }
    // if (!TemPress.isEmpty()) {
    // StringBuilder sb = new StringBuilder("SELECT
    // id,bookTitle,author,press,status,curtime From book");
    // sb.append(" WHERE author like \"%");
    // sb.append(TemAuthor);
    // ResultQuery(sb);
    // }
    // return book;
    // }

    // private static void ResultQuery(StringBuilder s) throws SQLException {
    // Statement sql = conn.createStatement();
    // s.append("%\"");
    // ResultSet books;
    // books = sql.executeQuery(s.toString());
    // while (books.next()) {
    // String bookTitle = books.getString("bookTitle");
    // String author = books.getString("author");
    // String press = books.getString("press");
    // int status = books.getInt("status");
    // LocalDateTime curtime = (LocalDateTime) books.getObject("curtime");
    // book.setBook(bookTitle, author, press, status, curtime);
    // }
    // }
}
