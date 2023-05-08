package 进程和线程.继承Thread类本身实现;

public class Test {
    public static void main(String[] args) {
        ExtThread thread1=new ExtThread("thread 1");
        thread1.start();
        ExtThread thread2=new ExtThread("thread 2");
        thread2.start();
    }
}
