package 集合.List集合.线程安全与否;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class IsSafe {
    public static void main(String[] args) {
        // ArrayList ，非线程安全
        ArrayList<Integer> integers = new ArrayList<>();

        // Vector 线程安全，但设计不好，已经弃用
        // 通过使用 Collections.synchronizedList 修饰，使 ArrayList 线程安全
        List<Integer> strings = Collections.synchronizedList(new ArrayList<>());
        // 也可以使用 JUC 包下的 List
        CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 6; i++) {
            integers.add(i);
            strings.add(i);
        }
        ThreadPoolExecutor executor = new ThreadPoolExecutor(6, 9, 10L, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<>(3));
        for (int i = 0; i < 6; i++) {

            executor.execute(() -> {
                String name = Thread.currentThread().getName();
                char c = name.charAt(name.length() - 1);
                String ss = c + "";
                int value = Integer.parseInt(ss);

                // 因为修改始终会覆盖值，所以修改不容易测出线程是否安全，但是对于添加的话，只要添加的数值不会被覆盖，就可以说明添加是线程安全的
                if (value <= 3) {
                    Controller.upOne(strings);
                } else {
                    Controller.upTwo(strings);
                }
                /*if (value <= 3) {
                    TempDemo.upOne(integers);
                } else {
                    TempDemo.upTwo(integers);
                }*/

                // 不好测试。。。
                /*if (strings.get(3) == 3) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (strings.get(3) == 3) {
                        strings.set(3, strings.get(3) + value);
                        System.out.println("当前值：" + strings.get(3) + " 当前线程：" + Thread.currentThread().getName());
                    }
                }*/
                /*if (integers.get(3) == 3) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (integers.get(3) == 3) {
                        integers.set(3, integers.get(3) + value);
                        System.out.println(name + " 当前值：" + strings.get(3) + " 当前线程：" + Thread.currentThread().getName());

                    }
                }*/
            });
        }
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(strings);
        System.out.println("strings.size() = " + strings.size());
        /*System.out.println(integers);
        System.out.println("integers.size() = " + integers.size());*/

    }
}
