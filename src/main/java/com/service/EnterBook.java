package LibMangeSystem.src.main.java.com.service;

import main.java.Setting;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

import java.time.*;

import LibMangeSystem.src.main.java.com.model.Book;
import LibMangeSystem.src.main.java.com.model.BorBook;

import javax.swing.*;

public class EnterBook {
    private static Connection conn = Setting.conMySql();

    public static boolean entryBook(String bookTitle, String author, String press) {
        PreparedStatement pstmt = null;
        // 判断传来的参数是否为空
        if (bookTitle.isEmpty() || author.isEmpty() || press.isEmpty()) {
            return false;
        }
        int rows = 0;
        try {
            String sql = "INSERT INTO book(bookTitle,author,press,status) VALUES(?,?,?,?)";
            // 开始录入
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bookTitle);
            pstmt.setString(2, author);
            pstmt.setString(3, press);
            pstmt.setInt(4, 0);
            rows = pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows > 0;
    }
}
