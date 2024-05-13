package StringBuilder类;


public class Test {
    /**
     * String 字符串常量
     * StringBuffer 字符串变量（线程安全）
     * StringBuilder 字符串变量（非线程安全）
     * StringBuffer 与 StringBuilder 大致相同，StringBuffer 几乎每个方法都加了同步锁，所以它是线程安全的。
     */
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder();
        s1.append("hello").append(" world");
        System.out.println(s1);
        StringBuilder s2 = s1;
        s2.reverse();
        System.out.println(s2);
        System.out.println(s1 == s2);
    }
}
