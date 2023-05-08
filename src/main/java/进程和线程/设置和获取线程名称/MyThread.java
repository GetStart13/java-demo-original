package 进程和线程.设置和获取线程名称;

public class MyThread extends Thread {
    public MyThread(){};
    public MyThread(String name){//将name传给它的父类，实现带参赋值
        super(name);
    };
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println(getName()+":"+i);

            /*try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}
