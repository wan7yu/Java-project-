package main.java.util;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ScreenSize {
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static int getScreenWidth() {
        return (int) screenSize.getWidth();
    }

    public static int getScreenHeight() {
        return (int) screenSize.getHeight();
    }
}
