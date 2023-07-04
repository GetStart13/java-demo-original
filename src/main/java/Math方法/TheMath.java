package Math方法;

import java.util.Random;

public class TheMath {
    public static void main(String[] args) {
        //返回参数的绝对值：
        System.out.println(Math.abs(12));
        System.out.println(Math.abs(-12));
        System.out.println("-----------");

        //返回大于或者等于参数的最小double值，等于一个整数：
        System.out.println(Math.ceil(12.34));
        System.out.println(Math.ceil(12.56));
        System.out.println("-----------");

        //返回小于或者等于参数的最小double值，等于一个整数：
        System.out.println(Math.floor(12.34));
        System.out.println(Math.floor(12.56));
        System.out.println("-----------");

        //按照四舍五入取最近参数的int
        System.out.println(Math.round(12.34F));
        System.out.println(Math.round(12.56F));
        System.out.println("-----------");

        //返回两个数中的较大值
        System.out.println(Math.max(12, 34));
        System.out.println("-----------");

        //返回两个数中较小值：
        System.out.println(Math.min(12, 34));
        System.out.println("-----------");

        //返回a的b次幂的值
        System.out.println(Math.pow(2.0, 3.0));
        System.out.println("-----------");

        //随机数，返回值为double的正值，范围：0.0 - 1.0
        System.out.println(new Random().nextInt() * 100);
        System.out.println("-----------");

    }
}

