package 数组排序;

import java.util.Arrays;
import java.util.Random;

public class test {
    public static void main(String[] args) {
        int bound=1000;
        Random rd=new Random();
        int[] array=new int[bound];
        for (int i = 0; i <bound; i++) {
            array[i]= rd.nextInt(bound);
        }
        System.out.println("排序前："+Arrays.toString(array));
        MySort.sort(array);
        System.out.println("排序后："+Arrays.toString(array));
    }
}
