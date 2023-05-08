package 数组.打乱一个有序数组;

import java.util.*;

public class 打乱数组2 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        int index = 100;
        for (int i = 1; i <= index; i++) {
            arr.add(i);
        }
        Collections.shuffle(arr);
        System.out.println(arr);
    }
}
