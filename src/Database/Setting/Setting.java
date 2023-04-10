package Database.Setting;

public class Setting {
    public static final String url = "jdbc:mysql://121.40.48.93/book_manage";
    public static final String username = "abc";
    public static final String password = "123456";

    public String[] getSetting() {
        String setting[] = { url, username, password };
        return setting;
    }
}
