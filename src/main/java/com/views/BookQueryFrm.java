package LibMangeSystem.src.main.java.com.views;

import LibMangeSystem.src.main.java.com.model.Book;
import LibMangeSystem.src.main.java.com.service.QueryBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static javax.swing.SwingConstants.HORIZONTAL;
import static javax.swing.SwingConstants.NORTH;

public class BookQueryFrm {
    public static void Frm() throws SQLException {
        // 创建窗口
        JFrame windows = new JFrame("图书查询功能");
        windows.setIconImage(new ImageIcon("LibMangeSystem/image/bookQuery.png").getImage());
        windows.setLayout(null);
        // 设置三个标签
        JLabel label1 = new JLabel("书名");
        label1.setBounds(30, 30, 50, 50);
        JLabel label2 = new JLabel("作者");
        label2.setBounds(280, 30, 50, 50);
        JLabel label3 = new JLabel("出版社");
        label3.setBounds(530, 30, 50, 50);
        // 设置三个文本框
        JTextField text1 = new JTextField(20);
        JTextField text2 = new JTextField(20);
        JTextField text3 = new JTextField(20);
        text1.setBounds(80, 40, 120, 40);
        text2.setBounds(330, 40, 120, 40);
        text3.setBounds(580, 40, 120, 40);

        // 加入查询到的图书,默认是全部图书
        Book[] defaultBook = QueryBook.queryAll();
        String[] colum = {"书名", "作者", "出版社", "借阅状态", "借阅时间"};
        String[][] data = new String[defaultBook.length][5];
        for (int i = 0; i < defaultBook.length; i++) {
            data[i][0] = defaultBook[i].getBookTitle();
            data[i][1] = defaultBook[i].getAuthor();
            data[i][2] = defaultBook[i].getPress();
            data[i][3] = defaultBook[i].getStatus();
            data[i][4] = defaultBook[i].getBorTime();
        }
        // 设置表格
        JTable table = new JTable(data, colum);
        table.setBounds(70, 120, 650, 400);
        // 设置滚动项
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(70, 120, 650, 400);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        // 设置按钮
        JButton search = new JButton("查询");
        JButton undo = new JButton("取消");
        JButton exit = new JButton("退出");
        undo.setBounds(30, 550, 60, 40);
        search.setBounds(350, 550, 60, 40);
        exit.setBounds(670, 550, 60, 40);

        // 设置事件
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEmpty(text1, text2, text3);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // 查询事件暂时有问题
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sBookTitle = text1.getText();
                String sAuthor = text2.getText();
                String sPress = text3.getText();

                try {
                    Book sBook = QueryBook.queryDefine(sBookTitle, sAuthor, sPress);
                    String[][] temDate = new String[1][6];
                    temDate[0][1] = sBook.getBookTitle();
                    temDate[0][2] = sBook.getAuthor();
                    temDate[0][3] = sBook.getPress();
                    temDate[0][4] = sBook.getStatus();
                    temDate[0][5] = sBook.getBorTime();
                    JTable temTable = new JTable(temDate,colum);
                    table.setVisible(false);
                    pane.add(temTable);
                    windows.repaint();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        windows.add(search);
        windows.add(undo);
        windows.add(exit);
        windows.add(label1);
        windows.add(label2);
        windows.add(label3);
        windows.add(text1);
        windows.add(text2);
        windows.add(text3);
        windows.add(pane);
        windows.setBounds(100, 100, 800, 650);
        windows.setResizable(false);
        windows.setVisible(true);
        windows.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private static void setEmpty(JTextField t1, JTextField t2, JTextField t3) {
        t1.setText("");
        t2.setText("");
        t3.setText("");
    }

}
