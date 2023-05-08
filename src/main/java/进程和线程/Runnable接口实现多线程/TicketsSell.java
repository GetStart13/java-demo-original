package 进程和线程.Runnable接口实现多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用接口的方式是为了让这个类能继承其他类
 * 同时也容易达到数据共享
 */
public class TicketsSell implements Runnable {
    private static int ticket = 100;

    //1、
    //private final Object obj = new Object();

    //2、
    //static int x = 0;

    //3、
    private final Lock lock = new ReentrantLock();


    @Override
    public void run() {

//------1
        /* while (true) {
            synchronized (obj) {//进程锁，当cpu中有进程正在执行时，不允许其他进程进入
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + ticket + "张票");
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }*/
//--------


//--------2
       /* while(true) {

        if (x % 2 == 0) {
            synchronized (TicketsSell.class) {//TicketsSell.class是指类的对象，静态修饰方法与 类 有关！！！
                                              //  this 是指类中非静态方法对象

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + ticket + "张票双");
                    ticket--;
                    x++;
                } else {
                    break;
                }
            }
        } else {
            sell();
        }
    }

}

    private static synchronized void sell() {//类中被静态修饰

        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在出售第" + ticket + "张票单");
            ticket--;
            x++;
        }
*/
//--------

//---------3、
        while (true) {
            try {
                //lock.lock(); //有进程，锁住
                if (ticket > 0) {
                    try {
                        // 多个线程之间互不影响，可能造成数据的不一致性，因此用某个它们共同的参照物对它们进行约束，只有获得该参照物的线程才能继续执行
                        //Thread.sleep(5000);
                        if (Thread.currentThread().getName().equals("win2")) {
                            // wait 必须发生在一个同步阻塞的对象监视器里（没有同步锁就会报错），但是 sleep 不需要。
                           // wait(3);
                            // sleep 即使没有同步锁，仍然可以休眠
                            Thread.sleep(100);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + ticket + "张票");
                    ticket--;
                } else {
                    break;
                }
            } finally {  // 进程执行完，释放锁
                //lock.unlock();
            }
        }

    }
}
