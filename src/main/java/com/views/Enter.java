package main.java.com.views;

import java.time.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import main.java.com.service.EntryPeople;

public class Enter {
    public void enterStudent() {
        // 创建一个窗口
        JFrame windows = new JFrame("图书管理系统");
        // 创建一个面板
        JPanel bodyJPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        // 创建菜单
        JMenuBar jMenuBar = new JMenuBar();
        JMenu bookQueryMenu = new JMenu("图书查询");
        JMenu stuQueryMenu = new JMenu("借书人员查询");
        JMenu bookEnterMenu = new JMenu("图书录入");
        JMenu stuEnterMenu = new JMenu("人员录入");
        jMenuBar.add(bookQueryMenu);
        jMenuBar.add(stuQueryMenu);
        jMenuBar.add(bookEnterMenu);
        jMenuBar.add(stuEnterMenu);
        // 设置垂直
        BoxLayout layout = new BoxLayout(bodyJPanel, BoxLayout.Y_AXIS);
        bodyJPanel.setLayout(layout);
        // 设置文本输入框
        JTextField stuIdField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JTextField borNumField = new JTextField(10);
        //
        JLabel stuJLabel = new JLabel("学号");
        JLabel nameJLabel = new JLabel("姓名");
        JLabel borNumJLabel = new JLabel("借阅数量");
        // 设置按钮
        JButton button1 = new JButton("取消");
        JButton button2 = new JButton("确认");
        // 添加组件
        bodyJPanel.add(stuJLabel);
        bodyJPanel.add(stuIdField);
        bodyJPanel.add(nameJLabel);
        bodyJPanel.add(nameField);
        bodyJPanel.add(borNumJLabel);
        bodyJPanel.add(borNumField);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        bottomPanel.add(Box.createHorizontalGlue());
        bottomPanel.add(button1);
        bottomPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        bottomPanel.add(button2);
        // 绑定事件
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 获取文本框信息
                String stuId = stuIdField.getText();
                String name = nameField.getText();
                String borNum = borNumField.getText();
                // 获取借书时间
                LocalTime nowTime = LocalTime.now();
                LocalDate nowDate = LocalDate.now();
                LocalDate endDate = nowDate.plusDays(120);
                LocalDateTime borTime = nowTime.atDate(nowDate);
                LocalDateTime endTime = nowTime.atDate(endDate);
                boolean success = EntryPeople.entryStundet(Integer.parseInt(stuId), name, Integer.parseInt(borNum),
                        borTime, endTime);
                if (success) {
                    System.out.println("添加成功");
                    // EntryPeople.entryBorBook(Integer.parseInt(stuId), Integer.parseInt(stuId),
                    // borTime);
                } else {
                    System.out.println("添加失败");
                }
                // 清空文本框
                stuIdField.setText("");
                nameField.setText("");
                borNumField.setText("");
            }
        });
        windows.setJMenuBar(jMenuBar);
        windows.add(bodyJPanel, BorderLayout.CENTER);
        windows.add(bottomPanel, BorderLayout.SOUTH);
        windows.setSize(400, 350);
        windows.setLocationRelativeTo(null);
        windows.setTitle("借书学生信息录入");
        windows.setVisible(true);
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}