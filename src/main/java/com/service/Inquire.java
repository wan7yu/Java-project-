package main.java.com.service;

import java.sql.*;
import java.util.ArrayList;

import main.java.Setting;

public class Inquire {
    private Connection conn = Setting.conMySql();

    public String[][] borStudentQuery() {
        // 创建一个可变的二维数组;
        ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
        ResultSet students = null;
        try {
            Statement sql = conn.createStatement();
            students = sql.executeQuery(
                    "select s.stuId,s.name,b.bookTitle,b.curTime from (student s left join borBook c on s.stuId = c.stuId) right join book b on b.id = c.bookId;");
            while (students.next()) {
                String stuId = Integer.toString(students.getInt(1));
                String name = students.getString(2);
                String bookTitle = students.getString(3);
                Timestamp curTime = students.getTimestamp(4);
                String stuCurTime = new String();
                if (curTime != null) {
                    stuCurTime = curTime.toString();
                }
                ArrayList<String> list = new ArrayList<String>();
                list.add(stuId);
                list.add(name);
                list.add(bookTitle);
                list.add(stuCurTime);
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