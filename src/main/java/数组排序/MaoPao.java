package 数组排序;

/*冒泡排序：交换排序*/

public class MaoPao {
    public static void main(String[] args) {

        int[] L = {6, 4, 8, 1, 2, 3, 7, 23, 12};
        int b = 0;//循环次数
        System.out.println("排序前：" + arrayToString(L));

        for (int i = 0; i < L.length; i++) {//外循环

            boolean a = true;//外循环内定义一个变量a，每次循环都会重新赋值

            for (int s = 0; s < L.length - i - 1; s++) {//内循环
                if (L[s] > L[s + 1]) {
                    int temp = L[s + 1];
                    L[s + 1] = L[s];
                    L[s] = temp;
                    a = false;
                }
                b += 1;
            }

            if (a) {//如果内循环没有发生交换改变，则终// 止程序

                break;
            }
        }
        System.out.println("循环" + b + "次");
        System.out.println("排序后："+arrayToString(L));

        /*for (int d : L) {
            System.out.println(d);
        }*/
    }

    public static String arrayToString(int[] arr) {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                s.append(arr[i]);
            } else {
                s.append(arr[i]).append(",");
            }
        }
        s.append("]");
        return s.toString();
    }
}
