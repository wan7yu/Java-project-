package main.java.com.views;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class Mune {

    // 创建窗口
    private JFrame systFrame = new JFrame("豫章图书馆");

    public void init() {
        // 创建菜单条
        JMenuBar menuBar = new JMenuBar();
        // 创建设置菜单
        JMenu siteJMenu = new JMenu("设置");
        JMenuItem logOutMenuItem = new JMenuItem("注销");
        JMenuItem exitMenuItem = new JMenuItem("退出");

        // 添加菜单条
        siteJMenu.add(logOutMenuItem);
        siteJMenu.add(exitMenuItem);
        menuBar.add(siteJMenu);
        systFrame.setJMenuBar(menuBar);

        // 创建分割面板
        JSplitPane splitPane = new JSplitPane();
        // 分割面板支持连续布局
        splitPane.setContinuousLayout(true);
        // 设置分割条的初始位置
        splitPane.setDividerLocation(150);
        // 设置分割条的初始大小
        splitPane.setDividerSize(7);

        // 创建树节点
        DefaultMutableTreeNode systemManage = new DefaultMutableTreeNode("系统管理");
        DefaultMutableTreeNode userManage = new DefaultMutableTreeNode("用户管理");
        DefaultMutableTreeNode bookManage = new DefaultMutableTreeNode("图书管理");
        DefaultMutableTreeNode borManage = new DefaultMutableTreeNode("借阅管理");
        // 添加树节点
        systemManage.add(userManage);
        systemManage.add(bookManage);
        systemManage.add(borManage);

        // 创建树形结构
        JTree systemJTree = new JTree(systemManage);

        // 树默认选中图书管理
        systemJTree.setSelectionRow(2);
        // 添加节点选择监听器
        systemJTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                // 获取当前选中的节点对象
                Object lastPathCompoent = e.getNewLeadSelectionPath().getLastPathComponent();

                if (userManage.equals(lastPathCompoent)) {
                    splitPane.setRightComponent(new JLabel("这里进行用户管理"));
                    splitPane.setDividerLocation(150);
                } else if (bookManage.equals(lastPathCompoent)) {
                    splitPane.setRightComponent(new ViewsEnter(systFrame));
                    splitPane.setDividerLocation(150);
                } else if (borManage.equals(lastPathCompoent)) {
                    splitPane.setRightComponent(new BorQuery(systFrame));
                    splitPane.setDividerLocation(150);
                }
            }
        });
        // 选中树节点发生的事件
        splitPane.setRightComponent(new ViewsEnter(systFrame));
        // 添加树形结构
        splitPane.setLeftComponent(systemJTree);

        // 添加分割面板
        systFrame.add(splitPane);

        // systFrame.add(panel);
        // systFrame.setBounds((1500 - width) / 2, (800 - height) / 2, width, height);
        // systFrame.setResizable(false);
        systFrame.pack();
        systFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Mune().init();
    }
}
