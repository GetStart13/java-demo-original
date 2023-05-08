package 进程和线程.线程池;

import java.util.ArrayList;
import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        /* corePoolSize： 线程池核心线程数最大值
         maximumPoolSize： 线程池最大线程数大小
         keepAliveTime： 线程池中非核心线程空闲的存活时间大小
         unit： 线程空闲存活时间单位
         workQueue： 存放任务的阻塞队列
         threadFactory： 用于设置创建线程的工厂，可以给创建的线程设置有意义的名字，可方便排查问题。
         handler：  线城池的拒绝策略，主要有四种类型。
        */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                5,
                1L,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 6; ++i) {
            int finalI = i;
            threadPoolExecutor.execute(() -> {
                // 如果当前线程名字最后一个字符为 1，休眠，'1'对应的 ascii 码是 49，也可以用 49 判断。
                if (Thread.currentThread().getName().charAt(Thread.currentThread().getName().length() - 1) == '1') {
                    try {
                        System.out.println("Thread.currentThread() " + Thread.currentThread().getName().charAt(Thread.currentThread().getName().length() - 1));
                        Thread.sleep(10000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println(Thread.currentThread().getName() + " ===>" + finalI);
                // System.out.println("Thread.currentThread() " + ((int)Thread.currentThread().getName().charAt(Thread.currentThread().getName().length() - 1)));
            });
        }
    }
}
