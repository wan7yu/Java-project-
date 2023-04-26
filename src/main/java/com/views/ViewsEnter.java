package main.java.com.views;

import java.time.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import main.java.com.service.EntryPeople;
import main.java.com.service.Update;

public class ViewsEnter {
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
        JButton cancel = new JButton("取消");
        JButton confirm = new JButton("确认");
        // body添加组件
        bodyJPanel.add(stuJLabel);
        bodyJPanel.add(stuIdField);
        bodyJPanel.add(nameJLabel);
        bodyJPanel.add(nameField);
        bodyJPanel.add(borNumJLabel);
        bodyJPanel.add(borNumField);
        // bottom添加组件
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        bottomPanel.add(Box.createHorizontalGlue());
        bottomPanel.add(cancel);
        bottomPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        bottomPanel.add(confirm);
        // 绑定事件
        confirm.addActionListener(new ActionListener() {
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
                // 添加borBook
                ViewsEnter enter = new ViewsEnter();
                enter.borBookEnter(Integer.parseInt(borNum), Integer.parseInt(stuId), borTime);
                // boolean bool = EntryPeople.entryStundet(Integer.parseInt(stuId), name,
                // Integer.parseInt(borNum),
                // borTime, endTime);
                Boolean bool = true;
                if (bool) {
                    JOptionPane.showMessageDialog(null, "添加成功!", "图书管理系统", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "添加失败!", "图书管理系统", JOptionPane.PLAIN_MESSAGE);
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

    public void borBookEnter(int borNum, int stuId, LocalDateTime curTime) {
        // 创建一个窗口
        JFrame windows = new JFrame();
        // 创建菜单条
        JMenuBar jMenuBar = new JMenuBar();
        // 创建菜单项
        JMenu bookQueryMenu = new JMenu("图书查询");
        JMenu stuQueryMenu = new JMenu("借书人员查询");
        JMenu bookEnterMenu = new JMenu("图书录入");
        JMenu stuEnterMenu = new JMenu("人员录入");
        // 往菜单条中加入菜单项
        jMenuBar.add(bookQueryMenu);
        jMenuBar.add(stuQueryMenu);
        jMenuBar.add(bookEnterMenu);
        jMenuBar.add(stuEnterMenu);
        // 创建一个面板
        JPanel bodyJPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        // body面板设置垂直
        BoxLayout layout = new BoxLayout(bodyJPanel, BoxLayout.Y_AXIS);
        bodyJPanel.setLayout(layout);
        // 添加标签
        JLabel label = new JLabel("书名");
        JTextField bookTitle = new JTextField();
        // 设置文本输入框
        for (int num = 0; num < borNum; num++) {
            // 修改文本框大小和位置
            bookTitle.setMaximumSize(new Dimension(200, 30));
            bookTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
            // 往body面板中加入标签和输入框
            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.LINE_AXIS));
            inputPanel.add(label);
            inputPanel.add(Box.createRigidArea(new Dimension(10, 0)));
            inputPanel.add(bookTitle);
            bodyJPanel.add(inputPanel);
        }
        // 设置按钮
        JButton cancel = new JButton("取消");
        JButton confirm = new JButton("确认");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EntryPeople enter = new EntryPeople();
                for (int num = 0; num < borNum; num++) {
                    JPanel inputPanel = (JPanel) bodyJPanel.getComponent(num);
                    JTextField bookTitle = (JTextField) inputPanel.getComponent(2);
                    String txt = bookTitle.getText();
                    int bookId = Integer.parseInt(txt);
                    Boolean enteryBool = enter.entryBorBook(bookId, stuId, curTime);
                    if (enteryBool == true) {
                        Update update = new Update();
                        Boolean updateBool = update.updateBook(bookId, curTime);
                        if (updateBool == true) {
                            continue;
                        } else {
                            JOptionPane.showMessageDialog(null, "添加失败!", "图书管理系统", JOptionPane.PLAIN_MESSAGE);
                            break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "添加失败!", "图书管理系统", JOptionPane.PLAIN_MESSAGE);
                        break;
                    }
                }
            }
        });
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 关闭当前窗口
                windows.dispose();
            }
        });
        // bottom添加组件
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        bottomPanel.add(Box.createHorizontalGlue());
        bottomPanel.add(cancel);
        bottomPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        bottomPanel.add(confirm);
        // 往窗口添加面板
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