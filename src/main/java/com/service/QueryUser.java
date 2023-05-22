package main.java.com.service;

import java.sql.*;
import java.util.ArrayList;

import main.java.*;

public class QueryUser {
    private static Connection conn = Setting.conMySql();

    public static String[][] userQuery() {
        // 创建一个可变的二维数组;
        ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
        ResultSet user = null;
        try {
            Statement sql = conn.createStatement();
            user = sql.executeQuery("select userId,password,name,borNum from user");
            while (user.next()) {
                String userId = Integer.toString(user.getInt(1));
                String password = user.getString(2);
                String name = user.getString(3);
                String borNum = Integer.toString(user.getInt(4));
                ArrayList<String> list = new ArrayList<String>();
                list.add(userId);
                list.add(password);
                list.add(name);
                list.add(borNum);
                lists.add(list);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[][] data = new String[lists.size()][4];
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < 4; j++) {
                data[i][j] = lists.get(i).get(j);
            }
        }
        return data;
    }
}
