package 进程和线程.线程控制;

import 进程和线程.设置和获取线程名称.MyThread;

public class 等待线程执行结束 {
    public static void main(String[] args) throws InterruptedException {
        MyThread mt1=new MyThread("公主");
        MyThread mt2=new MyThread("女巫");
        MyThread mt3=new MyThread("王子");

        mt1.start();
        mt1.join();//等待这个线程结束
        mt2.start();
        mt3.start();
    }
}
