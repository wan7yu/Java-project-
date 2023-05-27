package main.java.com.service;

import java.sql.*;
import java.time.*;

import main.java.Setting;

public class UpdateBor {
    private Connection conn = Setting.conMySql();

    public Boolean updateBook(int bookId, LocalDateTime curTime) {
        int rows = 0;
        try {
            Statement updateSql = conn.createStatement();
            String sql = "update book set curTime = ? where id = ? ;";
            ResultSet rs = updateSql.executeQuery(sql);
            if (!rs.next()) {
                return false;
            } else {

            }
            return true;
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
