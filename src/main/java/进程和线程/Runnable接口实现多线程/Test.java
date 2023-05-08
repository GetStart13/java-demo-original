package 进程和线程.Runnable接口实现多线程;

public class Test {
    public static void main(String[] args) {
        RunnableImpl R1 = new RunnableImpl("Thread-1");
        R1.start();
        RunnableImpl R2 = new RunnableImpl("Thread-2");
        R2.start();
    }
}
