package main.java.com.views;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import main.java.com.service.*;

public class UserManage extends Box {
    final int width = 850;
    final int hight = 600;

    private String[] titles = new String[] { "用户名", "密码", "姓名", "借阅数量" };
    private JTable table;
    private DefaultTableModel model;
    private Vector<String> columnName;
    private Vector<Vector<String>> tableData;
    private Query inquire = new QueryUser();

    public UserManage(JFrame jFrame) {
        super(BoxLayout.Y_AXIS);
        // 组装视图
        JPanel panel = new JPanel();
        panel.setMaximumSize(new Dimension(width, 80));
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // 创建按钮
        JButton addButton = new JButton("添加");
        JButton updateButton = new JButton("修改");
        JButton deleteButton = new JButton("删除");

        // 为按钮绑定事件
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBorDialog(jFrame, "添加用户", true).setVisible(true);
                // 刷新表格
                model.setDataVector(inquire.query(), toVector(titles));
            }
        });

        // 添加按钮
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        // 添加panel
        this.add(panel);
        // 组装表格
        initTable();
    }

    private void initTable() {
        // 组装表格
        columnName = toVector(titles);
        tableData = inquire.query();
        model = new DefaultTableModel(tableData, columnName);
        table = new JTable(model) {
            // 不允许点击表格来修改数据
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.fireTableDataChanged();
        // 只能单选
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.add(new JScrollPane(table));
    }

    public Vector<String> toVector(String[] titles) {
        return new Vector<>(Arrays.asList(titles));
    }

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }
}
