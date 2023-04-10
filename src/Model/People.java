package Model;

public class People {
    private int id;
    private String name;// 姓名
    private int sex; // 性别
    private int age; // 年龄
    private String phone; // 手机号
    private String email; // 邮箱
    private int bookid; // 借阅书籍
    private String borrowingTime; // 借阅时间

    public void create(String name, int sex, int age, String phone, String email, int bookid,
            String borrowingTime) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.bookid = bookid;
        this.borrowingTime = borrowingTime;
    }

    public void get() {
        System.out.println("id:" + id);
        System.out.println("姓名:" + name);
        System.out.println("性别:" + sex);
        System.out.println("年龄:" + age);
        System.out.println("手机号:" + phone);
        System.out.println("邮箱:" + email);
        System.out.println("借阅书籍:" + bookid);
        System.out.println("借阅时间:" + borrowingTime);
    }
}
