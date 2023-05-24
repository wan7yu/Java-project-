package main.java.com.views;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.com.service.QueryBor;
import main.java.util.*;

public class BorManage extends Box {

    final int width = 850;
    final int hight = 600;

    private JTable table;

    public BorManage(JFrame jFrame) {
        super(BoxLayout.Y_AXIS);

        // 组装视图
        JPanel panel = new JPanel();
        panel.setMaximumSize(new Dimension(width, 80));
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // 创建按钮
        JButton addButton = new JButton("添加");
        JButton updateButton = new JButton("修改");
        JButton deleteButton = new JButton("删除");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBorDialog(jFrame, "添加图书", true).setVisible(true);
            }
        });

        // 添加按钮
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        // 添加panel
        this.add(panel);
        // 组装表格
        String[] titles = { "学号", "姓名", "书籍名称", "借阅时间" };

        String[][] tableData = VectorToList.toStringList(QueryBor.borUserQuery());
        table = new JTable(tableData, titles) {
            @Override
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.add(new JScrollPane(table));
    }
}