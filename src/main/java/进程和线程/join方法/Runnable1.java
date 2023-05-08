package 进程和线程.join方法;

public class Runnable1 implements Runnable {
    private final Thread thread;
    private static final Runnable1 instance = new Runnable1();

    private Runnable1() {
        String[] strings = this.getClass().toString().split("\\.");
        thread = new Thread(this, strings[strings.length - 1]);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + "start...");
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                if (i == 5) {
                    Thread.sleep(3000);
                }
                Thread.sleep(1000);
            }
            System.out.println(Thread.currentThread().getName() + " " + "death.");
            if (this.thread.isAlive()) {
                System.out.println(Thread.currentThread().getName() + "线程仍然活着");
            }
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

    public static Runnable1 getInstance() {
        return instance;
    }
}
