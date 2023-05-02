package LibMangeSystem.src.main.java.com.views;

import LibMangeSystem.src.main.java.com.service.EntryPeople;

import java.time.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Enter {
    public void enterStudent() {
        // 创建一个窗口
        JFrame windows = new JFrame("图书管理系统");
        // 创建一个面板
        JPanel panel = new JPanel();
        // 设置垂直
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        // 设置文本输入框
        JTextField test1 = new JTextField(20);
        JTextField test2 = new JTextField(20);
        JTextField test3 = new JTextField(20);
        //
        JLabel label1 = new JLabel("学号");
        JLabel label2 = new JLabel("姓名");
        JLabel label3 = new JLabel("借阅数量");
        // 设置按钮
        JButton button1 = new JButton("取消");
        JButton button2 = new JButton("确认");
        // 添加组件
        panel.add(label1);
        panel.add(test1);
        panel.add(label2);
        panel.add(test2);
        panel.add(label3);
        panel.add(test3);
        panel.add(button1);
        panel.add(button2);
        // 绑定事件
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 获取文本框信息
                String stuId = test1.getText();
                String name = test2.getText();
                String borNum = test3.getText();
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
                test1.setText("");
                test2.setText("");
                test3.setText("");
            }
        });
        windows.add(panel, BorderLayout.CENTER);
        windows.setSize(400, 300);
        windows.setLocationRelativeTo(null);
        windows.setTitle("借书学生信息录入");
        windows.setVisible(true);
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}