package main.java.util;

import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import main.java.com.service.Query;

public class Table {

    private String[] titles;
    private JTable Jtable;
    private DefaultTableModel model;
    private Vector<String> columnName;
    private Vector<Vector<String>> tableData;

    public JScrollPane initTable(String[] titles, Query inquire) {
        this.titles = titles;
        // 组装表格
        columnName = toVector(titles);
        tableData = inquire.query();
        model = new DefaultTableModel(tableData, columnName);
        Jtable = new JTable(model) {
            // 不允许点击表格来修改数据
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.fireTableDataChanged();
        // 只能单选
        Jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return (new JScrollPane(Jtable));
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
