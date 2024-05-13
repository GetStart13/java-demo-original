package 自定义注解;

public class Person {

    /**
     * 方法同时被 @Deprecated 和 @MyAnnotation(value={"a","b"}) 标注：
     * <br>@Deprecated：意味着empty()方法，不再被建议使用。
     * <br>@MyAnnotation：不赋值 value，意味着 MyAnnotation 的 value 值是默认值 "unknown"。
     */
    @MyAnnotation
    @Deprecated(since = "仅用于测试")
    public void nobody() {
        System.out.println("empty...");
    }

    /**
     * 重复使用 @MyAnnotation 注解。
     */
    @MyAnnotation(values = {"men", "woman"})
    @MyAnnotation(values = {"girl", "boy"})
    public void somebody(String name, int age) {
        System.out.println("姓名：" + name + " 年龄：" + age);
    }
}
