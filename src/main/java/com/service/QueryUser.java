package main.java.com.service;

import java.sql.*;
import java.util.Vector;

import main.java.*;

public class QueryUser {
    private static Connection conn = Setting.conMySql();

    public static Vector<Vector<String>> userQuery() {
        // 创建一个可变的二维数组;
        Vector<Vector<String>> dataList = new Vector<>();
        ResultSet resultset = null;

        try {
            Statement statement = conn.createStatement();
            String sql = "select userId,password,name,borNum from user";
            resultset = statement.executeQuery(sql);
            if (!resultset.next()) {
                return dataList;
            }
            do {
                String userId = resultset.getString(1);
                String password = resultset.getString(2);
                String name = resultset.getString(3);
                String borNum = Integer.toString(resultset.getInt(4));
                // 存放数据的数组
                Vector<String> data = new Vector<>();

                data.add(userId);
                data.add(password);
                data.add(name);
                data.add(borNum);
                dataList.add(data);
            } while (resultset.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList;
    }
}
