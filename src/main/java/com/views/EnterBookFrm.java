package LibMangeSystem.src.main.java.com.views;

import LibMangeSystem.src.main.java.com.service.EnterBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterBookFrm {
    public static void Frm() {
        // 创建窗口
        JFrame windows = new JFrame("图书录入功能");
        windows.setIconImage(new ImageIcon("image/bookEnter.png").getImage());
        // 设置面板,采用绝对布局,既全部采用固定位置
        JPanel panel1 = new JPanel();
        panel1.setBounds(50, 50, 300, 200);
        panel1.setLayout(null);
        // 定义三个标签
        JLabel label1 = new JLabel("书 名");
        label1.setIcon(new ImageIcon("LibMangeSystem/image/bookTitle.png"));
        label1.setBounds(80, 30, 100, 70);
        JLabel label2 = new JLabel("作 者");
        label2.setIcon(new ImageIcon("LibMangeSystem/image/author.png"));
        label2.setBounds(80, 130, 100, 70);
        JLabel label3 = new JLabel("出版社");
        label3.setIcon(new ImageIcon("LibMangeSystem/image/press.png"));
        label3.setBounds(80, 230, 100, 70);
        // 定义三个文本框
        JTextField text1 = new JTextField(20);
        text1.setBounds(180, 45, 140, 40);
        JTextField text2 = new JTextField(20);
        text2.setBounds(180, 145, 140, 40);
        JTextField text3 = new JTextField(20);
        text3.setBounds(180, 245, 140, 40);
        // 定义三个按钮
        JButton undo = new JButton("取消");
        JButton confirm = new JButton("确定");
        JButton exit = new JButton("退出");
        confirm.setBounds(60, 320, 60, 40);
        undo.setBounds(200, 320, 60, 40);
        exit.setBounds(350, 320, 60, 40);

        // 绑定事件
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toEmpty(text1,text2,text3);
            }
        });
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // 获取文本
                String bookTitle = text1.getText();
                String author = text2.getText();
                String press = text3.getText();
                boolean flag = EnterBook.entryBook(bookTitle, author, press);
                if (flag){
                    JOptionPane.showMessageDialog(panel1, "录入成功");
                }else {
                    JOptionPane.showMessageDialog(panel1, "录入失败");
                }
                toEmpty(text1,text2,text3);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel1.add(label1);
        panel1.add(text1);
        panel1.add(label2);
        panel1.add(text2);
        panel1.add(label3);
        panel1.add(text3);
        panel1.add(undo);
        panel1.add(confirm);
        panel1.add(exit);

        windows.add(panel1);
        windows.setResizable(false);
        windows.setBounds(new Rectangle(50, 50, 500, 400));
        windows.setVisible(true);
        windows.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    // 清空方法
    public static void toEmpty(JTextField text1,JTextField text2,JTextField text3){
        text1.setText("");
        text2.setText("");
        text3.setText("");
    }
}
