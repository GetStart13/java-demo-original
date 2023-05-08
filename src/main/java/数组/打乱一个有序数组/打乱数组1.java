package 数组.打乱一个有序数组;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class 打乱数组1 {
    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        Random r = new Random();
        int index = 10;
        for (int i = 1; i <= index; i++) {
            arr1.add(i);
        }
        for (int i = index; i > 0; i--) {
            int ii = r.nextInt(i);
            arr2.add(arr1.get(ii));
            arr1.remove(ii);
        }
        System.out.println(arr2);
    }
}
