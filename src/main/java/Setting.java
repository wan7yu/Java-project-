package main.java;

public class Setting {
    public static String[] getMySql() {
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";
        String dbUrl = "jdbc:mysql://121.40.48.93/bookManage";
        String user = "abc";
        String password = "123456";
        String[] mysqlSet = new String[4];
        mysqlSet[0] = jdbcDriver;
        mysqlSet[1] = dbUrl;
        mysqlSet[2] = user;
        mysqlSet[3] = password;
        return mysqlSet;
    }
}
