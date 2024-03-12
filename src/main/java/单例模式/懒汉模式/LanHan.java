package 单例模式.懒汉模式;

public class LanHan { // 懒汉式：非线程安全，延迟初始化。
    private static LanHan lanhan;

    private LanHan() {
    }

    public static LanHan getLanHan() {
        if (lanhan == null) {
            lanhan = new LanHan();
        }
        return lanhan;
    }
}
