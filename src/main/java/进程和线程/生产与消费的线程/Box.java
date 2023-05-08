package 进程和线程.生产与消费的线程;

public class Box {
    private int box;  //声明私有成员变量，用于接收参数
    private boolean status = false;

    public synchronized void put(int box) {//从Produce传参数过来，初始参数值为 i = 0 ;0 赋值为 box,即 box = 0
        if (status) { //如果为真，相当于仓库Box中有产品，则休眠该线程
            try {
                wait(); //休眠
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
        this.box = box; // 实现传参
        System.out.println("生产第" + box + "个产品");
        status = true; //修改仓库状态
        notifyAll();    //唤醒所有线程
    }

    public synchronized void get() {

        if (!status) { //如果为假，相当于仓库Box中没有产品，则休眠该线程，等待生产
            try {
                wait(); //休眠
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("拿走第" + box + "个产品");
        status = false; // 产品被拿走，修改仓库状态
        notifyAll();    //唤醒所有线程
    }

}
