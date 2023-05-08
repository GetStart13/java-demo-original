package 进程和线程.Runnable接口实现多线程;

public class 售卖火车票 {
    public static void main(String[] args) {
        TicketsSell ts = new TicketsSell();
        Thread t1 = new Thread(ts, "win1");
        Thread t2 = new Thread(ts, "win2");
        Thread t3 = new Thread(ts, "win3");

        t2.start();
        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t3.start();


    }
}
