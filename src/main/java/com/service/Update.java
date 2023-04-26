package main.java.com.service;

import java.sql.*;
import java.time.*;

import main.java.Setting;

public class Update {
    private Connection conn = Setting.conMySql();

    public Boolean updateBook(int bookId, LocalDateTime curTime) {
        int rows = 0;
        try {
            Statement updateSql = conn.createStatement();
            rows = updateSql
                    .executeUpdate("update book set curTime = " + curTime + " where id = " + bookId + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rows > 0) {
            return true;
        } else {
            return false;
        }
    }
}
