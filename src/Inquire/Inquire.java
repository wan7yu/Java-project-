package Inquire;

import java.util.Scanner;
import Model.Book;
import Model.People;

public class Inquire {
    public void bookInquire(Book books[]) {
        System.out.println("开始查询!");
        System.out.println("请输入你需要查询的条件:");
        Scanner reader = new Scanner(System.in);
        String name;
        String author;
        int serialNumber;
        System.out.println("请输入需要查询的书籍的名称:");
        name = reader.next();
        System.out.println("请输入需要查询的书籍的作者名称:");
        author = reader.next();
        System.out.println("请输入需要查询的书籍的编号:");
        serialNumber = reader.nextInt();
        reader.close();
        for (Book book : books) {
            if (book.name == name && book.author == author && book.serialNumber == serialNumber) {
                book.get();
            } else {
                System.out.println("不好意思哦,没有符合您条件的书籍~");
            }
        }
    }

    public void peopleInquire() {
        System.out.println("开始查询!");
        People peoples = new People();
        peoples.get();
    }
}
