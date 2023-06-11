package main.java.com.views;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import main.java.com.model.User;
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
                new AddUserDialog(jFrame, "添加用户", true).setVisible(true);
                // 刷新表格
                model.setDataVector(inquire.query(), toVector(titles));
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 返回选中的行号,没有选中返回-1
                int selectdRow = table.getSelectedRow();
                if (selectdRow != -1) {
                    String userId = table.getValueAt(selectdRow, 0).toString();
                    String password = table.getValueAt(selectdRow, 1).toString();
                    String name = table.getValueAt(selectdRow, 2).toString();
                    String borNum = table.getValueAt(selectdRow, 3).toString();
                    User user = new User();
                    user.setUser(userId, password, name, Integer.parseInt(borNum));
                    new AddUserModifyDialog(jFrame, "修改用户", true, user);
                    // 刷新表格
                    model.setDataVector(inquire.query(), toVector(titles));
                } else {
                    JOptionPane.showMessageDialog(null, "请选择的修改的对象!");
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 返回选中的行号,没有选中返回-1
                int selectdRow = table.getSelectedRow();
                if (selectdRow != -1) {
                    int confirm = JOptionPane.showConfirmDialog(null, "确定要删除吗？",
                            "删除用户信息", JOptionPane.OK_CANCEL_OPTION);
                    // 确认要删除
                    if (confirm == 0) {
                        String userId = table.getValueAt(selectdRow, 0).toString();
                        if (new DeleteUser().deleteUser(userId)) {
                            JOptionPane.showMessageDialog(null, "删除成功");
                            // 刷新表格
                            model.setDataVector(inquire.query(), toVector(titles));
                        } else {
                            JOptionPane.showMessageDialog(null, "删除失败");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "请选择需要删除的对象!");
                }
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
