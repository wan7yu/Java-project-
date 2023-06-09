package main.java.com.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import main.java.util.*;
import main.java.com.service.UpdateBook;

public class AddBookModifyDialog extends JDialog {
    final int width = 600;
    final int height = 450;

    public AddBookModifyDialog(String columnName, String cell, JFrame jFrame, String title, Boolean isMode) {
        super(jFrame, title, isMode);
        // 转换为数据库中字段
        String Name = ToColumnName.toColName(columnName);
        main.java.com.model.Book book = main.java.com.service.QueryBook.queryModifyBook(Name, cell);
        // 如果未查到就提示查询失败
        if (book == null) {
            JOptionPane.showMessageDialog(null, "查询信息失败");
            return;
        }
        // 组装视图
        // 创建纵向容器
        Box vBox = Box.createVerticalBox();

        // 创建横向容器和创建username标签和输入框
        Box bookIdBox = Box.createHorizontalBox();
        JLabel bookIdLabel = new JLabel("图书编号: ");
        JTextField bookIdField = new JTextField();
        bookIdField.setText(book.getBookId());

        // 横向容器添加
        bookIdBox.add(bookIdLabel);
        bookIdBox.add(Box.createHorizontalStrut(20));
        bookIdBox.add(bookIdField);

        // 创建横向容器和创建username标签和输入框
        Box titleBox = Box.createHorizontalBox();
        JLabel titleLabel = new JLabel("图书名称: ");
        JTextField titleField = new JTextField();
        titleField.setText(book.getBookTitle());

        // 横向容器添加
        titleBox.add(titleLabel);
        titleBox.add(Box.createHorizontalStrut(20));
        titleBox.add(titleField);

        // 创建横向容器和创建password标签和输入框
        Box authorBox = Box.createHorizontalBox();
        JLabel authorJLabel = new JLabel("图书作者: ");
        JTextField authorField = new JTextField();
        authorField.setText(book.getAuthor());

        // 横向容器添加
        authorBox.add(authorJLabel);
        authorBox.add(Box.createHorizontalStrut(20));
        authorBox.add(authorField);

        // 创建横向容器和创建password标签和输入框
        Box pressBox = Box.createHorizontalBox();
        JLabel pressJLabel = new JLabel(" 出 版 社 : ");
        JTextField pressField = new JTextField();
        pressField.setText(book.getPress());

        // 横向容器添加
        pressBox.add(pressJLabel);
        pressBox.add(Box.createHorizontalStrut(20));
        pressBox.add(pressField);

        // 创建横向容器和创建password标签和输入框
        Box statusBox = Box.createHorizontalBox();
        JLabel statusJLabel = new JLabel("借阅状态: ");
        JTextField statusField = new JTextField();
        statusField.setText(book.getStatus());

        // 横向容器添加
        statusBox.add(statusJLabel);
        statusBox.add(Box.createHorizontalStrut(20));
        statusBox.add(statusField);

        // 创建横向容器和创建password标签和输入框
        Box curTimeBox = Box.createHorizontalBox();
        JLabel curTimeJLabel = new JLabel("借阅时间: ");
        JTextField curTimeField = new JTextField();
        LocalDateTime curTime = book.getCurTime();
        // 如果为空，不设置（空）
        if (curTime != null) {
            curTimeField.setText(String.valueOf(curTime));
        }

        // 横向容器添加
        curTimeBox.add(curTimeJLabel);
        curTimeBox.add(Box.createHorizontalStrut(20));
        curTimeBox.add(curTimeField);

        // 创建横向容器和创建password标签和输入框
        Box curStuIdBox = Box.createHorizontalBox();
        JLabel curStuIdJLabel = new JLabel("借阅学生: ");
        JTextField curStuIdField = new JTextField();
        curStuIdField.setText(book.getUserId());

        // 横向容器添加
        curStuIdBox.add(curStuIdJLabel);
        curStuIdBox.add(Box.createHorizontalStrut(20));
        curStuIdBox.add(curStuIdField);

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
                JOptionPane.showConfirmDialog(null, "是否修改？", "修改图书信息", JOptionPane.OK_CANCEL_OPTION);
                // 获取所有的文本
                String tmpBookId = bookIdField.getText();
                String tmpTitle = titleField.getText();
                String tmpAuthor = authorField.getText();
                String tmpPress = pressField.getText();
                String tmpStatus = statusField.getText();
                int status = 0;
                if (!tmpStatus.equals("")) {
                    status = Integer.parseInt(tmpStatus);
                }
                // 处理输入的时间 可能是 " "、2021 12 14、2021-12-14、2021:12:14
                String s = curTimeField.getText();
                Timestamp curTime = null;
                // 处理非法数据
                if (tmpBookId.equals("") || tmpTitle.equals("") || tmpAuthor.equals("")
                        || tmpPress.equals("")) {
                    JOptionPane.showMessageDialog(null, "输入数据有误！");
                    return;
                }
                if (!s.equals("") && status != 0) {
                    boolean isTime = s.matches("([01]\\d|2[0-3])([:\\-]?)[0-5]\\d([:\\-]?)[0-5]\\d");
                    // 如果满足格式
                    if (isTime) {
                        s = s.replaceAll("\\D|\\|:", "-");
                        curTime = Timestamp.valueOf(s);
                    }
                }
                String tmpStuId = curStuIdField.getText();
                if (curTime != null) {
                    book.setBook(tmpBookId, tmpTitle, tmpAuthor, tmpPress, Integer.parseInt(tmpStatus),
                            curTime.toLocalDateTime(), tmpStuId);
                }
                book.setBook(tmpBookId, tmpTitle, tmpAuthor, tmpPress, Integer.parseInt(tmpStatus),
                        null, tmpStuId);
                // 修改数据
                boolean isModify = UpdateBook.modifyBook(book);
                if (isModify) {
                    JOptionPane.showMessageDialog(null, "修改成功", "修改图书信息", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "修改失败", "修改图书信息", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        // 纵向容器添加
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(bookIdBox);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(titleBox);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(authorBox);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(pressBox);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(statusBox);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(curTimeBox);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(curStuIdBox);
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
