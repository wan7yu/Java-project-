package Enter;

import java.util.Scanner;

import Model.Book;
import Model.People;

public class Enter {
    public void EnterBook() {
        System.out.println("开始录入书籍！提示:输入编号为-1时结束录入");
        Scanner reader = new Scanner(System.in);
        Book books[];
        int nums = 0;
        while (true) {
            Book book = new Book();// 创建一个book对象
            int serialNumber; // 编号
            String name; // 书名
            String author;// 作者
            String enterTime;// 录入时间
            System.out.printf("请输入编号：");
            serialNumber = reader.nextInt();
            if (serialNumber == -1) {
                System.out.println("输入已结束！");
                reader.close();
                break;
            }
            System.out.printf("请输入书名：");
            name = reader.next();
            System.out.printf("请输入作者：");
            author = reader.next();
            System.out.printf("请输入录入时间:");
            enterTime = reader.next();
            book.create(serialNumber, name, author, enterTime);
            books = new Book[nums + 1];
            books[nums] = book;
            nums = nums + 1;
        }
    }

    public void EnterPeople() {
        System.out.println("开始录入人员!提示:输入编号为-1时结束录入");
        Scanner reader = new Scanner(System.in);
        People peoples[];
        int nums = 0;
        while (true) {
            People people = new People();
            String name;// 姓名
            int sex; // 性别
            int age; // 年龄
            String phone; // 手机号
            String email; // 邮箱
            int bookid;
            String borrowingTime;
            System.out.println("请输入人员姓名:");
            name = reader.next();
            if (name == "#") {
                System.out.println("人员信息录入结束!");
                reader.close();
                break;
            }
            System.out.println("请输入人员性别:");
            sex = reader.nextInt();
            System.out.println("请输入人员年龄:");
            age = reader.nextInt();
            System.out.println("请输入人员手机号:");
            phone = reader.next();
            System.out.println("请输入人员邮箱:");
            email = reader.next();
            System.out.println("请输入借阅书籍名称:");
            bookid = reader.nextInt();
            System.out.println("请输入人员邮箱:");
            borrowingTime = reader.next();
            people.create(name, sex, age, phone, email, bookid, borrowingTime);
            peoples = new People[nums + 1];
            peoples[nums] = people;
            nums = nums + 1;
        }
    }
}
