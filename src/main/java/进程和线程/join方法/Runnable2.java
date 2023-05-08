package 进程和线程.join方法;


import java.util.Objects;

public class Runnable2 implements Runnable {
    private final Thread thread;  //设置thread常量，不允许调用者更改
    private static final Runnable2 instance = new Runnable2();  //不允许创建多个实例，且不允许修改实例

    private Runnable2() { //私有方法，禁止通过构造方法创建对象
        String[] strings = this.getClass().toString().split("\\.");
        String string = strings[strings.length - 1];
        thread = new Thread(this, string);

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start。。.");
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i + "two");
                Thread.sleep(1000);
            }
            Thread thread1 = Runnable1.getInstance().getThread();
            thread1.join(); //Runnable1的线程调用了join方法，Runnable2的线程执行到此处后，会一直等待Runnable1执行结束才会继续往下执行
            // thread.join(); //如果当前线程在自己执行期间自己调用join方法，就会变成死锁，无限等待

            System.out.println("当前执行的线程是成员变量的thread吗："+Objects.equals(thread.getName(), Thread.currentThread().getName()));
            System.out.println(Thread.currentThread().getName() + " death.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void toStart() {
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    public static Runnable2 getInstance() {
        return instance;
    }
}
