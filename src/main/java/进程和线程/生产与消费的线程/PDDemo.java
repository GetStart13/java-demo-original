package 进程和线程.生产与消费的线程;

public class PDDemo {
    public static void main(String[] args) {
        Box box = new Box();//创建一个Box对象

        Produce produce = new Produce(box);//Produce中构造方法以Box对象为参数，创建Produce对象
        Customer customer = new Customer(box);

        Thread thread1 = new Thread(produce,"生产者");//通过实现了Runnable接口的类Produce的对象创建线程
        Thread thread2 = new Thread(customer,"消费者");

        thread1.start();//启动线程
        thread2.start();
    }
}
