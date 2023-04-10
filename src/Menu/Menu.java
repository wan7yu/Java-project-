package Menu;

import Enter.Enter;

import java.util.Scanner;

public class Menu {
    public void menu() {
        System.out.println("-----欢迎来到图书管理系统--------");
        System.out.println("-------1.图书的录入-------------");
        System.out.println("-------2.人员信息的录入---------");
        System.out.println("-------3.图书的查询-------------");
        System.out.println("-------4.借阅图书的录入----------");
        System.out.println("-------5.人员借阅信息的显示------");
        Scanner reader = new Scanner(System.in);
        System.out.printf("请输入你的选择:");
        int num = reader.nextInt();
        reader.close();
        while (true) {
            switch (num) {
                case 1: {
                    System.out.println("图书录入");
                    Enter enter = new Enter();
                    enter.EnterBook();
                    break;
                }
                case 2: {
                    System.out.println("人员信息的录入");
                    break;
                }
                case 3: {
                    System.out.println("图书的查询");
                    break;
                }
                case 4: {
                    System.out.println("借阅图书的录入");
                    break;
                }
                case 5: {
                    System.out.println("人员借阅信息的显示");
                    break;
                }
                default: {
                    System.out.println("输入错误!请从新输入:");
                    continue;
                }
            }
        }
    }
}
