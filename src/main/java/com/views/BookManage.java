package main.java.com.views;

import main.java.util.ToColumnName;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import main.java.util.Table;
import main.java.com.service.*;

public class BookManage extends Box {

    final int width = 850;
    final int hight = 600;
    private Connection conn = main.java.Setting.conMySql();
    // 标题
    private String[] titles = new String[] { "图书编号", "书名", "作者", "出版社", "借阅状态", "借阅学生", "借阅时间" };
    private JTable Jtable;
    private DefaultTableModel model;
    private Statement stmt;
    private Table table = new Table();
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
                new AddBookDialog(jFrame, "添加图书", true).setVisible(true);
                // 刷新表格
                model.setDataVector(inquire.query(), table.toVector(titles));
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 返回选中的行号以及对应列,没有选中返回-1
                int selectdRow = Jtable.getSelectedRow();
                int selectColumn = Jtable.getSelectedColumn();
                if (selectdRow != -1 && selectColumn != -1) {
                    String name = model.getColumnName(selectColumn);
                    String cell = (String) model.getValueAt(selectdRow, selectColumn);
                    new AddBookModifyDialog(name, cell, jFrame, "修改图书", true);

                    model.setDataVector(inquire.query(), table.toVector(titles));
                } else {
                    JOptionPane.showMessageDialog(null, "请选择的修改的对象!");
                    return;
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 选中的行和列
                int selectRow = Jtable.getSelectedRow();
                int selectColumn = Jtable.getSelectedColumn();
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
                    return;
                }
                // 刷新表格
                model.setDataVector(inquire.query(), table.toVector(titles));
            }
        });

        // 添加按钮
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        // 添加panel
        this.add(panel);
        // 组装表格
        this.add(table.initTable(titles, inquire));
    }
}