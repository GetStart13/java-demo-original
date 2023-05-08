package 单例模式.双检索;

public class ShuangJianSuo { // 双检锁：线程安全，延迟初始化
    private static volatile ShuangJianSuo shuangJianSuo;

    private ShuangJianSuo() {

    }

    public static ShuangJianSuo getShuangJianSuo() {
        if (shuangJianSuo == null) {
            synchronized (ShuangJianSuo.class) {
                if (shuangJianSuo == null) {
                    shuangJianSuo = new ShuangJianSuo();
                }
            }
        }
        return shuangJianSuo;
    }
}
