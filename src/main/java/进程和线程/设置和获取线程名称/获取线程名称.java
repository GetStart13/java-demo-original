package 进程和线程.设置和获取线程名称;

public class 获取线程名称 {
    public static void main(String[] args) {
//        MyThread my1 = new MyThread();
//        MyThread my2 = new MyThread();

        //命名
//        my1.setName("线程1");
//        my2.setName("线程2");

        //带参赋值
        /*MyThread my1=new MyThread("线程3");
        MyThread my2=new MyThread("线程4");*/

        //线程开启
//        my1.start();
//        my2.start();

//        String name = my1.getName();//获取正在运行的线程的名称
//        System.out.println(name);

        System.out.println(Thread.currentThread().getName());//获取当前运行的线程的名称

    }
}
