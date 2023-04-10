package Model;

public class Book {
    private int id;
    private int serialNumber;// 编号
    private String name; // 书名
    private String author;// 作者
    private String enterTime;// 录入时间
    private String cullTime;// 剔除时间

    public void createBook(int serialNumber, String name, String author, String enterTime) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.author = author;
        this.enterTime = enterTime;
    }

    public void get() {
        System.out.println("id:" + id);
        System.out.println("编号:" + serialNumber);
        System.out.println("书名:" + name);
        System.out.println("作者:" + author);
        System.out.println("录入时间:" + enterTime);
        System.out.println("剔除时间:" + cullTime);
    }
}
