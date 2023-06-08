package main.java.com.service;

import java.sql.*;

import main.java.Setting;

public class DeleteBor {
    private Connection conn = Setting.conMySql();

    public Boolean deleteBor(String booktitle) {
        PreparedStatement pstmt = null;
        int rows = 0;
        try {
            Statement statement = conn.createStatement();
            // 查询借阅记录
            ResultSet bor = statement.executeQuery(
                    "SELECT u.userId FROM borBook bb JOIN user u ON bb.userId = u.id JOIN book b ON bb.bookId = b.id WHERE b.booktitle = "
                            + booktitle + ";");
            // 判断是否存在查询结果
            if (!bor.next()) {
                return false;
            }
            String sql = "DELETE bor WHERE bookTitle = " + booktitle + ";";
            rows = conn.createStatement().executeUpdate(sql);

            if (rows > 0) {
                rows = 0;
                try {
                    String updateUser = "UPDATE user set borNum = borNum - 1 WHERE userId = ?";
                    pstmt = conn.prepareStatement(updateUser);
                    pstmt.setString(1, bor.getString(1));
                    rows = pstmt.executeUpdate();
                    if (rows > 0) {
                        rows = 0;
                        try {
                            String updatebook = "UPDATE book set status = 0,curUser = null,curTime = null , endTime =null WHERE bookTitle = ?;";
                            pstmt = conn.prepareStatement(updatebook);
                            pstmt.setString(1, booktitle);
                            rows = pstmt.executeUpdate();
                            if (rows > 0) {
                                return true;
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
