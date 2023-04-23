package LibMangeSystem.src.main.java.com.views;

import javax.swing.*;
import java.awt.*;

public class Menu {
    public void menu() {
        // 创建一个窗口
        JFrame windows = new JFrame("图书管理系统");
        // 创建一个面板
        JPanel panel = new JPanel();
        // 设置垂直
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);

        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // 创建按钮
        JButton bookQuery = new JButton("图书查询");
        JButton stuQuery = new JButton("借书人员查询");
        JButton bookEnter = new JButton("图书录入");
        JButton stuEnter = new JButton("人员录入");
        // 设置按钮最大大小
        Dimension buttonSize = new Dimension(200, 50);
        bookQuery.setMaximumSize(buttonSize);
        stuQuery.setMaximumSize(buttonSize);
        bookEnter.setMaximumSize(buttonSize);
        stuEnter.setMaximumSize(buttonSize);
        // 设置按钮大小
        bookQuery.setPreferredSize(buttonSize);
        stuQuery.setPreferredSize(buttonSize);
        bookEnter.setPreferredSize(buttonSize);
        stuEnter.setPreferredSize(buttonSize);
        // 往面板中加按钮
        panel.add(Box.createVerticalGlue());
        panel.add(bookQuery);
        panel.add(Box.createVerticalStrut(10));
        panel.add(stuQuery);
        panel.add(Box.createVerticalStrut(10));
        panel.add(bookEnter);
        panel.add(Box.createVerticalStrut(10));
        panel.add(stuEnter);
        panel.add(Box.createVerticalGlue());
        // 往窗口添加容器
        windows.add(panel, BorderLayout.CENTER);
        windows.setSize(400, 300);
        windows.setLocationRelativeTo(null);
        windows.setTitle("图书管理系统");
        windows.setVisible(true);
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
