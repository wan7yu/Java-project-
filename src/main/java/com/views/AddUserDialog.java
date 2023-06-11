package main.java.com.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import main.java.com.model.User;
import main.java.com.service.*;
import main.java.util.ScreenSize;

public class AddUserDialog extends JDialog {
    final int width = 350;
    final int height = 250;

    public AddUserDialog(JFrame jFrame, String title, Boolean isMode) {
        super(jFrame, title, isMode);
        // 组装视图
        // 创建纵向容器
        Box vBox = Box.createVerticalBox();

        // 创建横向容器和创建username标签和输入框
        Box UserIdBox = Box.createHorizontalBox();
        JLabel UserIdLabel = new JLabel("学    号: ");
        JTextField UserIdField = new JTextField();

        // 横向容器添加
        UserIdBox.add(UserIdLabel);
        UserIdBox.add(Box.createHorizontalStrut(20));
        UserIdBox.add(UserIdField);

        // 创建横向容器和创建username标签和输入框
        Box passwordBox = Box.createHorizontalBox();
        JLabel passwordLabel = new JLabel("密    码: ");
        JTextField passwordField = new JTextField();

        // 横向容器添加
        passwordBox.add(passwordLabel);
        passwordBox.add(Box.createHorizontalStrut(20));
        passwordBox.add(passwordField);

        // 创建横向容器和创建password标签和输入框
        Box nameBox = Box.createHorizontalBox();
        JLabel nameJLabel = new JLabel("姓    名: ");
        JTextField nameField = new JTextField();

        // 横向容器添加
        nameBox.add(nameJLabel);
        nameBox.add(Box.createHorizontalStrut(20));
        nameBox.add(nameField);

        // 创建横向容器和创建按钮
        Box bBox = Box.createHorizontalBox();
        JButton confirmButton = new JButton("确认");
        JButton cancelButton = new JButton("取消");

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int isOk = JOptionPane.showConfirmDialog(null, "确认添加", "添加用户信息", JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
                // 如果确认要添加，需要获取数据
                // 调用entryBook方法，同时刷新表格。
                if (isOk == 0) {
                    String UserId = UserIdField.getText();
                    String password = passwordField.getText();
                    String name = nameField.getText();
                    // 处理非法数据
                    User user = new User();
                    user.setUser(UserId, password, name, 0);
                    String msg = null;
                    if (EntryUser.entryUser(user)) {
                        msg = "添加成功!";
                        JOptionPane.showMessageDialog(null, msg, "添加用户", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        msg = "添加失败!";
                        JOptionPane.showMessageDialog(null, msg, "添加用户", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 直接隐藏界面
                dispose();
            }
        });

        // 横向容器添加
        bBox.add(confirmButton);
        bBox.add(Box.createHorizontalStrut(60));
        bBox.add(cancelButton);

        vBox.add(Box.createVerticalStrut(30));
        vBox.add(UserIdBox);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(passwordBox);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(nameBox);
        vBox.add(Box.createVerticalStrut(20));
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
