package 常量与变量;

public class 局部变量与成员变量与全局变量与常量 {
    // 成员变量默认初始化为 null
    private String 成员变量;
    private final String 成员常量 = "成员常量必须手动初始化，可以直接指定值或者在所有构造方法中指定值";
    // 类变量归类所有，在类初始化时初始化，且只初始化一次
    private static String 类变量;

    public static void main(String[] args) {

    }

    void 局部变量() {
        String variable = "局部变量必须手动初始化，可以延迟初始化";
        System.out.println(variable);
    }
}
