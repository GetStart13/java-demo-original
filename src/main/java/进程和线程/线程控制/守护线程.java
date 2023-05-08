package 进程和线程.线程控制;

import 进程和线程.设置和获取线程名称.MyThread;

public class 守护线程 {
    public static void main(String[] args) {
        MyThread mt1=new MyThread("公主");
        MyThread mt2=new MyThread("女巫");

        mt1.setDaemon(true);//设置为守护线程，当线程中只剩下这些线程在执行时，java虚拟机退出
        mt2.setDaemon(true);//本例中，当“王子”进程结束时，Java虚拟机退出

        mt1.start();
        mt2.start();

        Thread wz = Thread.currentThread();
        wz.setName("王子");
        wz.setPriority(10);
        for (int i=0;i<10;i++){
            System.out.println(wz.getName()+":"+i);
        }

    }
}
