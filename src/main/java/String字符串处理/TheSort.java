package String字符串处理;


import java.util.Arrays;

public class TheSort {
    public static void main(String[] args) {
        // 将字符组转换成数组，并按数字顺序排序输出数组
        String str = "33 55 22 77 33";

        String[] s1 = str.split(" ");// 将字符串内容按" "分割成字符串组

        int[] gg = TheSort.convert(s1);// 调用方法

        System.out.println("排序前：" + Arrays.toString(TheSort.convert(s1)));

        Arrays.sort(gg);//排序
        System.out.println("排序后：" + Arrays.toString(gg));
    }

    public static int[] convert(String[] str) {// 创建一个将字符串组转换成字符组的方法
        int[] aa = new int[str.length];// 新建一个数组对象aa，长度为字符串组长度
        for (int i = 0; i < str.length; i++) {
            aa[i] = Integer.parseInt(str[i]);// 遍历，将遍历的字符串组转换为int型并赋值给对应数组
        }
        return aa;
    }
}
