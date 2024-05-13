package 数组.复制数组;

import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] b = new int[10];
        // a 是旧数组，b 是新数组
        System.arraycopy(a, 3, b, 0, 5);
        System.out.println("复制后" + Arrays.toString(b));
    }
}
