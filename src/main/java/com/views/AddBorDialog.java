package main.java.com.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddBorDialog extends JDialog {

    public AddBorDialog(JFrame jFrame, String title, Boolean isModel) {
        super(jFrame, title, isModel);
        // 组装视图
        // 创建纵向容器
        Box vBox = Box.createVerticalBox();

        // 创建横向容器和创建username标签和输入框
        Box stuIdBox = Box.createHorizontalBox();
        JLabel stuIdLabel = new JLabel("学       号: ");
        JTextField stuIdField = new JTextField();

        // 横向容器添加
        stuIdBox.add(stuIdLabel);
        stuIdBox.add(Box.createHorizontalStrut(20));
        stuIdBox.add(stuIdField);

        // 创建横向容器和创建username标签和输入框
        Box nameBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("姓       名: ");
        JTextField nameField = new JTextField();

        // 横向容器添加
        nameBox.add(nameLabel);
        nameBox.add(Box.createHorizontalStrut(20));
        nameBox.add(nameField);

        // 创建横向容器和创建password标签和输入框
        Box titledBox = Box.createHorizontalBox();
        JLabel titleJLabel = new JLabel("书籍名称: ");
        JTextField titleField = new JTextField();

        // 横向容器添加
        titledBox.add(titleJLabel);
        titledBox.add(Box.createHorizontalStrut(20));
        titledBox.add(titleField);

        // 创建横向容器和创建password标签和输入框
        Box curTimeBox = Box.createHorizontalBox();
        JLabel curTimeJLabel = new JLabel("借阅时间: ");
        JTextField curTimeField = new JTextField();

        // 横向容器添加
        curTimeBox.add(curTimeJLabel);
        curTimeBox.add(Box.createHorizontalStrut(20));
        curTimeBox.add(curTimeField);

        // 创建横向容器和创建按钮
        Box bBox = Box.createHorizontalBox();
        JButton confirmButton = new JButton("确认");
        JButton cancelButton = new JButton("取消");

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // 横向容器添加
        bBox.add(confirmButton);
        bBox.add(Box.createHorizontalStrut(60));
        bBox.add(cancelButton);

        vBox.add(Box.createVerticalStrut(30));
        vBox.add(stuIdBox);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(nameBox);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(titledBox);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(curTimeBox);
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
    }
}
