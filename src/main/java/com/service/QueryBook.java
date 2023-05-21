package main.java.com.service;

import main.java.com.model.Book;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class QueryBook {
    private static Connection conn = main.java.Setting.conMySql();
    public static Book book;

    // 查询所有图书
    public static Book[] queryAll() throws SQLException {
        ArrayList<Book> AllBook = new ArrayList<>();
        Statement sql = conn.createStatement();
        ResultSet aBooks;
        aBooks = sql.executeQuery("SELECT bookTitle,author,press,status,curTime FROM book");
        while (aBooks.next()) {
            Book abook = new Book();
            AllBook.add(abook);
            String bookTitle = aBooks.getString("bookTitle");
            String author = aBooks.getString("author");
            String press = aBooks.getString("press");
            int status = aBooks.getInt("status");
            LocalDateTime curtime = (LocalDateTime) aBooks.getObject("curtime");
            abook.setBook(bookTitle, author, press, status, curtime);
        }
        Book[] books = new Book[AllBook.size()];
        for (int i = 0; i < AllBook.size(); i++) {
            books[i] = AllBook.get(i);
        }
        return books;
    }

    // 查询指定书的方法
    public static Book queryDefine(String TemBookTitle, String TemAuthor, String TemPress) throws SQLException {
        if (!TemBookTitle.isEmpty()) {
            StringBuilder sb = new StringBuilder("SELECT id,bookTitle,author,press,status,curtime FROM book");
            sb.append(" WHERE bookTitle like \"%");
            sb.append(TemBookTitle);
            ResultQuery(sb);
        }
        if (!TemAuthor.isEmpty()) {

            StringBuilder sb = new StringBuilder("SELECT id,bookTitle,author,press,status,curtime From book");
            sb.append(" WHERE author like \"%");
            sb.append(TemAuthor);
            ResultQuery(sb);
        }
        if (!TemPress.isEmpty()) {
            StringBuilder sb = new StringBuilder("SELECT id,bookTitle,author,press,status,curtime From book");
            sb.append(" WHERE author like \"%");
            sb.append(TemAuthor);
            ResultQuery(sb);
        }
        return book;
    }

    private static void ResultQuery(StringBuilder s) throws SQLException {
        Statement sql = conn.createStatement();
        s.append("%\"");
        ResultSet books;
        books = sql.executeQuery(s.toString());
        while (books.next()) {
            String bookTitle = books.getString("bookTitle");
            String author = books.getString("author");
            String press = books.getString("press");
            int status = books.getInt("status");
            LocalDateTime curtime = (LocalDateTime) books.getObject("curtime");
            book.setBook(bookTitle, author, press, status, curtime);
        }
    }
}
