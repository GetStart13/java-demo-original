package 常量与变量;

public class FieldDemo {
    // 成员变量默认初始化为 null
    private String field;
    // final 修饰的成员常量必须手动初始化：直接赋值或者在所有构造方法中赋值
    private final String finalField = "initialize";
    // 静态变量归类所有，在类初始化时初始化，且只初始化一次
    private static String staticField;

    public static void main(String[] args) {

    }

    void fieldMethod() {
        // 局部变量必须手动初始化，可以延迟初始化
        String variable = "value";
        System.out.println(variable);
    }
}
