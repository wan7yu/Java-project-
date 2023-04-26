package main.java.com.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.com.service.Inquire;

public class ViewsQuery {
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
        Inquire query = new Inquire();
        String[][] data = query.borStudentQuery();
        // 创建表格的表头
        String[] columnNames = { "学号", "姓名", "借阅书籍名称", "借阅时间" };
        // 创建一个表格，并设置表格数据和表头
        JTable table = new JTable(data, columnNames);

        // 将表格添加到一个滚动面板中，并设置滚动面板的尺寸和布局
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 300));
        scrollPane.setLayout(new ScrollPaneLayout());
        // 设置按钮
        JButton cancel = new JButton("取消");
        JButton confirm = new JButton("确认");
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "您当前的操作有风险，您确定要继续吗？", "确认", JOptionPane.PLAIN_MESSAGE);
            }
        });
        // 创建面板
        JPanel bottomPanel = new JPanel();
        // 设置面板布局
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        // 添加面板组件
        bottomPanel.add(Box.createHorizontalGlue());
        bottomPanel.add(cancel);
        bottomPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        bottomPanel.add(confirm);
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

    public void studentQuery() {

    }
}
