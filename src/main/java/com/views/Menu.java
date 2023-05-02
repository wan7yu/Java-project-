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
        JButton button1 = new JButton("图书查询");
        JButton button2 = new JButton("借书人员查询");
        JButton button3 = new JButton("图书录入");
        JButton button4 = new JButton("人员录入");
        // 设置按钮最大大小
        Dimension buttonSize = new Dimension(200, 50);
        button1.setMaximumSize(buttonSize);
        button2.setMaximumSize(buttonSize);
        button3.setMaximumSize(buttonSize);
        button4.setMaximumSize(buttonSize);
        // 设置按钮大小
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);
        button4.setPreferredSize(buttonSize);
        // 往面板中加按钮
        panel.add(Box.createVerticalGlue());
        panel.add(button1);
        panel.add(Box.createVerticalStrut(10));
        panel.add(button2);
        panel.add(Box.createVerticalStrut(10));
        panel.add(button3);
        panel.add(Box.createVerticalStrut(10));
        panel.add(button4);
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
