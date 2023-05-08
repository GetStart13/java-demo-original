package 数组.Arrays操作数组;

import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] arr={4,3,2,6,2,7};

        //输出数组：
        System.out.println("排序前："+ Arrays.toString(arr));
        //按数字顺序排序数组：

        Arrays.sort(arr);
        System.out.println("排序后："+Arrays.toString(arr));

    }
}
