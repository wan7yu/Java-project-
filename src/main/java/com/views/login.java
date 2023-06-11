package main.java.com.views;

import javax.swing.*;
import java.awt.event.*;

import main.Manage;
import main.java.com.service.Login;
import main.java.util.ScreenSize;

public class login {
    // 创建面板
    private JFrame loginFrame = new JFrame("豫章图书馆");

    // 定义窗口大小
    final int width = 500;
    final int height = 300;

    public void init() {

        // 创建一个容器
        JPanel panel = new JPanel();

        // 创建纵向容器
        Box vBox = Box.createVerticalBox();

        // 创建横向容器和创建username标签和输入框
        Box unBox = Box.createHorizontalBox();
        JLabel unLabel = new JLabel("用户名:");
        JTextField unField = new JTextField();

        // 横向容器添加
        unBox.add(unLabel);
        unBox.add(Box.createHorizontalStrut(20));
        unBox.add(unField);

        // 创建横向容器和创建password标签和输入框
        Box pwBox = Box.createHorizontalBox();
        JLabel pwJLabel = new JLabel("密    码:");
        JTextField pwField = new JTextField();

        // 横向容器添加
        pwBox.add(pwJLabel);
        pwBox.add(Box.createHorizontalStrut(20));
        pwBox.add(pwField);

        // 创建横向容器和创建按钮
        Box bBox = Box.createHorizontalBox();
        JButton confirmButton = new JButton("登录");
        JButton cancelButton = new JButton("退出");

        // 按钮绑定事件
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = unField.getText().trim();
                String password = pwField.getText().trim();
                if (Login.login(userId, Integer.parseInt(password))) {
                    new Mune().init();
                    loginFrame.dispose();
                } else {
                    String msg = "用户名或者密码错误!";
                    JOptionPane.showMessageDialog(null, msg);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 关闭当前窗口
                loginFrame.dispose();
            }
        });

        // 横向容器添加按钮
        bBox.add(confirmButton);
        bBox.add(Box.createHorizontalStrut(60));
        bBox.add(cancelButton);

        // 纵向添加容器
        vBox.add(Box.createVerticalStrut(40));
        vBox.add(unBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(pwBox);
        vBox.add(Box.createVerticalStrut(40));
        vBox.add(bBox);

        // 窗口添加容器
        panel.add(vBox);
        loginFrame.add(panel);
        loginFrame.setBounds((ScreenSize.getScreenWidth() - width) / 2, (ScreenSize.getScreenHeight() - height) / 2,
                width, height);
        // 设置不允许改窗口大小
        loginFrame.setResizable(false);
        loginFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new login().init();
    }
}
