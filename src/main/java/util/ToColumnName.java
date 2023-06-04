package LibMangeSystem.src.main.java.util;

public class ToColumnName {
    public static String toColName(String Name) {
        if (Name.equals("图书编号")) {
            return "bookId";
        } else if (Name.equals("书名")) {
            return "bookTitle";
        } else if (Name.equals("作者")) {
            return "author";
        } else if (Name.equals("出版社")) {
            return "press";
        } else if (Name.equals("借阅学生")){
            return "userId";
        } else if (Name.equals("借阅时间"))
            return "curTime";
        return "";
    }
}
