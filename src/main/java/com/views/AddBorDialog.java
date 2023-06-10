package main.java.com.views;

import java.time.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import main.java.util.*;
import main.java.com.model.*;
import main.java.com.service.*;

public class AddBorDialog extends JDialog {
    final int width = 400;
    final int height = 250;

    public AddBorDialog(JFrame jFrame, String title, Boolean isModel) {
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
        JButton confirmButton = new JButton("确认");
        JButton cancelButton = new JButton("取消");

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取输入框信息
                int isOk = JOptionPane.showConfirmDialog(null, "确认添加?", "添加借阅记录", JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
                if (isOk == 0) {
                    String userId = userField.getText().trim();
                    String name = nameField.getText().trim();
                    String bookId = bookIdField.getText().trim();
                    // 获取当前时间
                    LocalDateTime curTime = LocalDateTime.now();
                    LocalDateTime endTime = curTime.plusDays(120);
                    BorBook borBook = new BorBook();
                    int user = Verify.getUserId(userId, name);
                    String msg = null;
                    if (user == 0) {
                        msg = "用户不存在";
                        JOptionPane.showMessageDialog(null, msg);
                        return;
                    }
                    int book = Verify.getBookId(bookId);
                    if (book == 0) {
                        msg = "书籍不存在或被借走";
                        JOptionPane.showMessageDialog(null, msg);
                        return;
                    }
                    borBook.setBorBook(book, user, curTime, endTime);
                    if (EnterBor.enterBor(borBook, bookId)) {
                        msg = "添加成功!";
                        JOptionPane.showMessageDialog(null, msg, "添加借阅记录", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        msg = "添加失败!";
                        JOptionPane.showMessageDialog(null, msg, "添加借阅记录", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                dispose();
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
        this.setBounds((ScreenSize.getScreenWidth() - width) / 2, (ScreenSize.getScreenHeight() - height) / 2, width,
                height);
        this.setVisible(true);
    }
}
