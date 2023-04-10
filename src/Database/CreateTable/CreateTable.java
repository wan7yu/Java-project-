package Database.CreateTable;

import java.sql.*;
import java.lang.reflect.Field;

import Database.Setting.Setting;
import Model.Book;

public class CreateTable {
    public void getTable() {
        Class bookClass = Book.class;
        String className = bookClass.getName();// 拿到类名
        Field[] fields = bookClass.getDeclaredFields();// 拿到类里所有类型的成员变量
        String SQL = "CREATE TABLE IF NOT EXISTS" + className + "(\n";
        for (Field field : fields) {
            Class type = field.getType();
            if (type == "java.lang.String") {
                type = "varchar(64)";
            }
            String name = (String) field.getName();
            SQL = SQL + type + name;
        }
        SQL = SQL + ");";
    }

    public void createTable(){
        Setting setting = new Setting();
        String set[] = setting.getSetting();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// 加载MySQL数据库驱动
        } catch (Exception e) {
            e.printStackTrace(); // 不知道作用
            System.out.println("未能成功加载数据库驱动程序！");
        }
        try{
            Connection connection =DriverManager.getConnection(set[0],set[1],set[2]); // 连接数据库
            Statement stmt = connection.createStatement();
            String table;
            String tableName = "create table if not exists"+table+"("+")";
            ResultSet rs = stmt.executeQuery("select * from studentlist");
        }
    }
}
