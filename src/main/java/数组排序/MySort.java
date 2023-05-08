package 数组排序;

public class MySort {
    public static int[] sort(int[] array) {
        long startTime = System.nanoTime(); //程序开始执行时间
        int times = 0;  //统计执行次数
        int temp1 = 0;  //动态生成数组长度
        for (int value : array
        ) {
            if (temp1 < value) {
                temp1 = value;  //取到最大值用于初始化数组
            }
            times++;
        }
        int[] temp = new int[temp1+1];  //初始化
        int zero = 0;   //对于特殊数值0分开统计
        for (int value : array) {
            if (value == 0) {
                zero += 1;  //统计需要排序的数组内有多少个 "0" 数值
                times++;
            }
            temp[value] = temp[value] == 0 ? value : temp[value] + 1;   //处理出现的重复数字
            times++;
        }
        for (int j = 0; j < zero; j++) {
            times++;
            array[j] = 0;   //数值0重新放回数组
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0) {
                while (temp[i] >= i) {  //重新将数组放回原数组
                    array[zero] = i;
                    zero += 1;
                    temp[i]--;
                    times++;
                }
            }
        }
        System.out.println("我的排序算法排序了:" + times + "次");
        long endTime = System.nanoTime();
        System.out.println("sort it spends:" + (endTime - startTime) + "ns.");
        return array;
    }
}
