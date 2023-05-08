package 进程和线程.生产与消费的线程;

public class Produce implements Runnable {

    private Box box;    //声明私有成员变量，用于接收Box类型的参数

    public Produce(Box box) {   //接收参数
        this.box = box;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {    //设定运行次数，若没有指定，则线程周期中只运行一次！！！
            box.put(i);     //线程运行后，通过对象box调用Box类的put方法，并有参数传递，初始传参 i=0；
        }
    }


}
