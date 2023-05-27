package main.java.com.service;

import java.sql.*;
import java.util.Vector;

import main.java.Setting;

public class QueryBor {
    private static Connection conn = Setting.conMySql();

    public static Vector<Vector<String>> borUserQuery() {
        // 创建一个可变的二维数组;
        Vector<Vector<String>> dataList = new Vector<>();
        ResultSet resultset = null;
        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT u.userId, u.name, b.bookTitle, bb.curTime,bb.endTime FROM borBook bb JOIN user u ON bb.userId = u.id JOIN book b ON bb.bookId = b.id;";
            resultset = statement.executeQuery(sql);
            // 判断是否存在查询结果
            if (!resultset.next()) {
                return dataList;
            }
            do {
                String userId = resultset.getString(1);
                String name = resultset.getString(2);
                String bookTitle = resultset.getString(3);
                Timestamp curTime = resultset.getTimestamp(4);
                Timestamp endTime = resultset.getTimestamp(5);
                String userCurTime = new String();
                if (curTime != null) {
                    userCurTime = curTime.toString();
                }
                String userEndTIme = new String();
                if (endTime != null) {
                    userEndTIme = endTime.toString();
                }
                Vector<String> data = new Vector<>();
                data.add(userId);
                data.add(name);
                data.add(bookTitle);
                data.add(userCurTime);
                data.add(userEndTIme);
                dataList.add(data);
            } while (resultset.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList;
    }
}