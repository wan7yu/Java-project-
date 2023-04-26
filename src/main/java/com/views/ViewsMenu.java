package main.java.com.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewsMenu {
    public void menu() {
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
        // 创建按钮
        JButton bookQuery = new JButton("图书查询");
        JButton stuQuery = new JButton("借书人员查询");
        JButton bookEnter = new JButton("图书录入");
        JButton stuEnter = new JButton("人员录入");
        // 设置按钮最大大小
        Dimension buttonSize = new Dimension(200, 50);
        bookQuery.setMaximumSize(buttonSize);
        stuQuery.setMaximumSize(buttonSize);
        bookEnter.setMaximumSize(buttonSize);
        stuEnter.setMaximumSize(buttonSize);
        // 设置按钮大小
        bookQuery.setPreferredSize(buttonSize);
        stuQuery.setPreferredSize(buttonSize);
        bookEnter.setPreferredSize(buttonSize);
        stuEnter.setPreferredSize(buttonSize);
        // bookQuery按钮绑定事件
        // Query querys = new Query();
        // Enter enters = new Enter();
        bookQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("图书查询");
            }
        });
        // studentQuery 按钮绑定事件
        stuQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("借书人员查询");
                // querys.studentQuery();
            }
        });
        bookEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("图书录入");
                // enters.bookEnter();
            }
        });
        stuEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("人员录入");
                // enters.enterStudent();
            }
        });
        // 创建一个面板
        JPanel bodyJPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        // 将组件填充到整个可用空间
        gbc.fill = GridBagConstraints.BOTH;
        // 将组件的横向和纵向权重都设置为1，以便它们平均分配可用空间
        gbc.weightx = 1;
        gbc.weighty = 1;

        // 往面板中加按钮
        bodyJPanel.add(Box.createVerticalGlue(), gbc);
        gbc.gridy = 1;
        bodyJPanel.add(bookQuery, gbc);
        gbc.gridy = 2;
        bodyJPanel.add(Box.createVerticalStrut(10), gbc);
        gbc.gridy = 3;
        bodyJPanel.add(stuQuery, gbc);
        gbc.gridy = 4;
        bodyJPanel.add(Box.createVerticalStrut(10), gbc);
        gbc.gridy = 5;
        bodyJPanel.add(bookEnter, gbc);
        gbc.gridy = 6;
        bodyJPanel.add(Box.createVerticalStrut(10), gbc);
        gbc.gridy = 7;
        bodyJPanel.add(stuEnter, gbc);
        gbc.gridy = 8;
        bodyJPanel.add(Box.createVerticalGlue(), gbc);
        // // 设置垂直
        // BoxLayout layout = new BoxLayout(bodyJPanel, BoxLayout.Y_AXIS);
        // bodyJPanel.setLayout(layout);
        // // 往面板中加按钮
        // bodyJPanel.add(Box.createVerticalGlue());
        // bodyJPanel.add(bookQuery);
        // bodyJPanel.add(Box.createVerticalStrut(10));
        // bodyJPanel.add(stuQuery);
        // bodyJPanel.add(Box.createVerticalStrut(10));
        // bodyJPanel.add(bookEnter);
        // bodyJPanel.add(Box.createVerticalStrut(10));
        // bodyJPanel.add(stuEnter);
        // bodyJPanel.add(Box.createVerticalGlue());
        // 创建一个窗口
        JFrame windows = new JFrame("图书管理系统");
        // 往窗口添加容器
        windows.setJMenuBar(jMenuBar);
        windows.add(bodyJPanel, BorderLayout.CENTER);
        windows.setSize(400, 350);
        windows.setLocationRelativeTo(null);
        windows.setTitle("图书管理系统");
        windows.setVisible(true);
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
