package 数组.二维数组;

import java.util.Arrays;

public class DoubleArrays {
    public static void main(String[] args) {
        doubleArraysTest();
    }

    static void doubleArraysTest() {
        String[][] doubleArrays = {{"1", "2", "3"}, {"4", "5"}};
        System.out.println("矩阵: ");
        for (String[] doubleArray : doubleArrays) {
            System.out.println(Arrays.toString(doubleArray));
        }
        System.out.println("长度: " + doubleArrays.length);
    }
}
