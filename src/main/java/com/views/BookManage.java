package main.java.com.views;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.util.*;
import main.java.com.service.*;

public class BookManage extends Box {
    final int width = 850;
    final int hight = 600;
    // 标题
    private String[] titles = new String[] { "图书编号", "书名", "作者", "出版社", "借阅状态", "借阅学生", "借阅时间" };
    private JTable table;
    private DefaultTableModel model;
    private Vector<String> columnName;
    private Vector<Vector<String>> tableData;
    private Connection conn = main.java.Setting.conMySql();
    private Statement stmt;
    private Query inquire = new QueryBook();

    public BookManage(JFrame jFrame) {
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
                new main.java.com.views.AddBookDialog(jFrame, "添加图书", true).setVisible(true);
                // 刷新表格
                model.setDataVector(inquire.query(), toVector(titles));
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 返回选中的行号以及对应列,没有选中返回-1
                int selectdRow = table.getSelectedRow();
                int selectColumn = table.getSelectedColumn();
                if (selectdRow != -1 && selectColumn != -1) {
                    String name = model.getColumnName(selectColumn);
                    String cell = (String) model.getValueAt(selectdRow, selectColumn);
                    new main.java.com.views.AddBookModifyDialog(name, cell, jFrame, "修改图书", true);

                    model.setDataVector(inquire.query(), toVector(titles));
                } else {
                    JOptionPane.showMessageDialog(null, "请选择的修改的对象!");
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 选中的行和列
                int selectRow = table.getSelectedRow();
                int selectColumn = table.getSelectedColumn();
                if (selectRow != -1 && selectColumn != -1) {
                    int confirm = JOptionPane.showConfirmDialog(null, "确定要删除吗？",
                            "删除图书信息", JOptionPane.OK_CANCEL_OPTION);
                    // 确认要删除
                    if (confirm == 0) {
                        // 删除对应数据
                        // 字段名
                        String columnName = model.getColumnName(selectColumn);
                        // 在对应字段下对应的行的值
                        String cell = (String) model.getValueAt(selectRow, selectColumn);
                        System.out.println(cell);
                        System.out.println(columnName);
                        if (!columnName.equals("借阅状态")) {
                            columnName = ToColumnName.toColName(columnName);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "删除失败，请选择书中具有标识性的信息。", "删除错误", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        try {
                            stmt = conn.createStatement();
                            String sql = "DELETE FROM book WHERE " + columnName + "=" + "'" + cell + "' ;";
                            int isDelete = stmt.executeUpdate(sql);
                            if (isDelete != 0) {
                                JOptionPane.showMessageDialog(null, "删除成功");
                            } else {
                                JOptionPane.showMessageDialog(null, "删除失败");
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "请选择要删除的列！");
                }
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