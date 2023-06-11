package main.java.com.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.util.*;
import main.java.com.model.*;
import main.java.com.service.*;

public class AddUserModifyDialog extends JDialog {
    final int width = 350;
    final int height = 250;

    public AddUserModifyDialog(JFrame jFrame, String title, Boolean isMode, User user) {
        super(jFrame, title, isMode);
        // 组装视图
        // 创建纵向容器
        Box vBox = Box.createVerticalBox();

        // 创建横向容器和创建username标签和输入框
        Box UserIdBox = Box.createHorizontalBox();
        JLabel UserIdLabel = new JLabel("学    号: ");
        JTextField UserIdField = new JTextField();
        UserIdField.setText(user.getUserId());

        // 横向容器添加
        UserIdBox.add(UserIdLabel);
        UserIdBox.add(Box.createHorizontalStrut(20));
        UserIdBox.add(UserIdField);

        // 创建横向容器和创建username标签和输入框
        Box passwordBox = Box.createHorizontalBox();
        JLabel passwordLabel = new JLabel("密    码: ");
        JTextField passwordField = new JTextField();
        passwordField.setText(user.getPassword());

        // 横向容器添加
        passwordBox.add(passwordLabel);
        passwordBox.add(Box.createHorizontalStrut(20));
        passwordBox.add(passwordField);

        // 创建横向容器和创建password标签和输入框
        Box nameBox = Box.createHorizontalBox();
        JLabel nameJLabel = new JLabel("姓    名: ");
        JTextField nameField = new JTextField();
        nameField.setText(user.getName());

        // 横向容器添加
        nameBox.add(nameJLabel);
        nameBox.add(Box.createHorizontalStrut(20));
        nameBox.add(nameField);

        // 创建横向容器和创建按钮
        Box bBox = Box.createHorizontalBox();
        JButton confirmButton = new JButton("确认");
        JButton cancelButton = new JButton("取消");

        // 横向容器添加
        bBox.add(confirmButton);
        bBox.add(Box.createHorizontalStrut(60));
        bBox.add(cancelButton);

        // 添加监听器
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 弹出弹框
                int confirm = JOptionPane.showConfirmDialog(null, "是否修改？", "修改用户信息", JOptionPane.OK_CANCEL_OPTION);
                if (confirm == 0) {
                    // 获取所有的文本
                    String userId = UserIdField.getText();
                    String password = passwordField.getText();
                    String name = nameField.getText();
                    User user = new User();
                    // 创建用户
                    user.setUser(userId, password, name, 0);

                    String msg = null;
                    // 修改数据
                    if (UpdateUser.updateUser(user, userId)) {
                        msg = "修改成功";
                        JOptionPane.showMessageDialog(null, msg, "修改用户信息", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        msg = "修改失败";
                        JOptionPane.showMessageDialog(null, msg, "修改用户信息", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // 纵向容器添加
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(UserIdBox);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(passwordBox);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(nameBox);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(bBox);
        vBox.add(Box.createVerticalStrut(20));

        // 添加左右间隔
        Box hBox = Box.createHorizontalBox();
        hBox.add(Box.createHorizontalStrut(50));
        hBox.add(vBox);
        hBox.add(Box.createHorizontalStrut(50));
        // 添加自定义容器
        this.add(hBox);
        this.setBounds((ScreenSize.getScreenWidth() - width) / 2, (ScreenSize.getScreenHeight() - height) / 2,
                width, height);
        this.setVisible(true);
    }
}
