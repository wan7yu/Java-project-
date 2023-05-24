package main.java.util;

import java.util.Vector;

public class VectorToList {
    public static String[][] toStringList(Vector<Vector<String>> vectorData) {

        int rows = vectorData.size();
        // 判断是否为空二维动态数组
        if (rows == 0) {
            return new String[0][0];
        }
        int cols = vectorData.get(0).size();

        String[][] dataArray = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            Vector<String> rowData = vectorData.get(i);
            for (int j = 0; j < cols; j++) {
                dataArray[i][j] = rowData.get(j);
            }
        }
        return dataArray;
    }
}