package main.java.com.views;

import java.time.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.java.com.service.*;
import main.java.com.model.*;
import main.java.util.*;

public class UpdateBor extends JDialog {

    public UpdateBor(JFrame jFrame, String title, Boolean isModel, String id) {
        super(jFrame, title, isModel);
        // 组装视图
        // 创建纵向容器
        Box vBox = Box.createVerticalBox();

        // 创建横向容器和创建username标签和输入框
        Box userBox = Box.createHorizontalBox();
        JLabel userLabel = new JLabel("学       号: ");
        JTextField userField = new JTextField();

        // 横向容器添加
        userBox.add(userLabel);
        userBox.add(Box.createHorizontalStrut(20));
        userBox.add(userField);

        // 创建横向容器和创建username标签和输入框
        Box nameBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("姓       名: ");
        JTextField nameField = new JTextField();

        // 横向容器添加
        nameBox.add(nameLabel);
        nameBox.add(Box.createHorizontalStrut(20));
        nameBox.add(nameField);

        // 创建横向容器和创建password标签和输入框
        Box bookIdBox = Box.createHorizontalBox();
        JLabel bookIdJLabel = new JLabel("书籍编号: ");
        JTextField bookIdField = new JTextField();

        // 横向容器添加
        bookIdBox.add(bookIdJLabel);
        bookIdBox.add(Box.createHorizontalStrut(20));
        bookIdBox.add(bookIdField);

        // 创建横向容器和创建按钮
        Box bBox = Box.createHorizontalBox();
        JButton confirmButton = new JButton("修改");
        JButton cancelButton = new JButton("取消");

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取输入框信息
                String[][] tableData = VectorToList.toStringList(QueryBor.borUserQuery());
                for (int i = 0; i < tableData.length; i++) {
                    userField.setText(tableData[i][0]);
                    nameField.setText(tableData[i][1]);
                    bookIdField.setText(tableData[i][2]);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // 横向容器添加
        bBox.add(confirmButton);
        bBox.add(Box.createHorizontalStrut(60));
        bBox.add(cancelButton);

        vBox.add(Box.createVerticalStrut(30));
        vBox.add(userBox);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(nameBox);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(bookIdBox);
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
    }
}
