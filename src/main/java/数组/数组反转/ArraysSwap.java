package 数组.数组反转;

import java.util.Arrays;

public class ArraysSwap {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(new ArraysSwap().swap(arr)));
    }

    public int[] swap(int[] arr) {
        for (int start = 0, end = arr.length - 1; start < end; start++, end--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        return arr;
    }
}
