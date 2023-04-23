package main.java.com.views;

import javax.swing.*;
import java.awt.*;

public class Query {
    public static void bookQuery() {
        // 创建菜单
        JMenuBar jMenuBar = new JMenuBar();
        JMenu bookQueryMenu = new JMenu("图书查询");
        JMenu stuQueryMenu = new JMenu("借书人员查询");
        JMenu bookEnterMenu = new JMenu("图书录入");
        JMenu stuEnterMenu = new JMenu("人员录入");
        // 添加菜单项
        jMenuBar.add(bookQueryMenu);
        jMenuBar.add(stuQueryMenu);
        jMenuBar.add(bookEnterMenu);
        jMenuBar.add(stuEnterMenu);
        // 创建表格数据
        Object[][] bookData = {
                { "Java编程思想", "Bruce Eckel", "机械工业出版社", "2007-06-01" },
                { "Java核心技术", "Cay S. Horstmann, Gary Cornell", "机械工业出版社", "2013-09-01" },
                { "Effective Java", "Joshua Bloch", "机械工业出版社", "2018-08-01" },
                { "深入浅出设计模式", "程杰", "电子工业出版社", "2014-11-01" },
                { "Head First 设计模式", "Eric Freeman, Elisabeth Robson", "中国电力出版社", "2011-01-01" }
        };
        // 创建表格的表头
        String[] columnNames = { "书名", "作者", "出版社", "出版日期" };

        // 创建一个表格，并设置表格数据和表头
        JTable table = new JTable(bookData, columnNames);

        // 将表格添加到一个滚动面板中，并设置滚动面板的尺寸和布局
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 300));
        scrollPane.setLayout(new ScrollPaneLayout());
        // 设置按钮
        JButton button1 = new JButton("取消");
        JButton button2 = new JButton("确认");
        // 创建面板
        JPanel bottomPanel = new JPanel();
        // 设置面板布局
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        // 添加面板组件
        bottomPanel.add(Box.createHorizontalGlue());
        bottomPanel.add(button1);
        bottomPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        bottomPanel.add(button2);
        // 创建一个窗口
        JFrame windows = new JFrame("图书管理系统");
        // 往窗口添加组件
        windows.setJMenuBar(jMenuBar);
        windows.add(scrollPane);
        windows.add(bottomPanel, BorderLayout.SOUTH);
        windows.setSize(400, 350);
        windows.setLocationRelativeTo(null);
        windows.setTitle("图书查询");
        windows.setVisible(true);
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
