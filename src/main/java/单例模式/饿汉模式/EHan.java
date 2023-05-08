package 单例模式.饿汉模式;

public class EHan { // 饿汉式：线程安全，静态变量是随着类加载时被完成初始化的，它在内存中仅有一个，且JVM也只会为它分配一次内存。
    private static final EHan eHan = new EHan(); // 警告是因为 Class 中，只包含了静态变量，静态方法，idea 认为你没有必要去 new 出来一个对象，
    // 所以进行了提示。实用程序类 'EHan' 的实例化 / Instantiation of utility class

    private EHan() {

    }

    public static EHan geteHan() {
        return eHan;
    }
}
