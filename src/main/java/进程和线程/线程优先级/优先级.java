package 进程和线程.线程优先级;

import 进程和线程.设置和获取线程名称.MyThread;

public class 优先级 {
    public static void main(String[] args) {
        MyThread mt1=new MyThread("华为");
        MyThread mt2=new MyThread("小米");
        MyThread mt3=new MyThread("vivo");

        //获取线程优先级
        /*int m1 = mt1.getPriority();
        int m2 = mt2.getPriority();
        int m3 = mt3.getPriority();
        System.out.println(m1+","+m2+","+m3);

        //获取最大，最小，默认优先级
        System.out.println(Thread.MAX_PRIORITY + Thread.MIN_PRIORITY +Thread.NORM_PRIORITY);
*/

        //设置线程优先级
        mt1.setPriority(10);
        mt2.setPriority(6);
        mt3.setPriority(7);

        //启动线程
        mt1.start();
        mt2.start();
        mt3.start();
    }
}
