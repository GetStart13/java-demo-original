package 进程和线程.线程控制;

import 进程和线程.设置和获取线程名称.MyThread;

public class 线程睡眠 {
    public static void main(String[] args) {
        MyThread mt1=new MyThread("公主");
        MyThread mt2=new MyThread("女巫");
        MyThread mt3=new MyThread("王子");

        //run方法里调用Thread.sleep()方法，设置睡眠时间
        mt1.start();
        mt2.start();
        mt3.start();
    }
}
