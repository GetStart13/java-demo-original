package 进程和线程.生产与消费的线程;

public class Customer implements Runnable {
    private Box box;

    public Customer(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (true) {  //设定运行次数，本次死循环，无限运行
            box.get();

        }
    }
}
