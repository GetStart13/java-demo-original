package 自定义注解;

public class Person {

    /**
     * empty()方法同时被 "@Deprecated" 和 "@MyAnnotation(value={"a","b"})"所标注
     * (01) @Deprecated，意味着empty()方法，不再被建议使用
     * (02) @MyAnnotation, 意味着empty() 方法对应的MyAnnotation的value值是默认值"unknown"
     */

    @MyAnnotate
    @Deprecated
    public void empty() {
        System.out.println("empty...");
    }

    /**
     * somebody() 被 @MyAnnotation(value={"girl","boy"}) 所标注，
     * 意味着MyAnnotation的value值是{"girl","boy"}
     */

    @MyAnnotate(values = {"men","woman"})
    @MyAnnotate(values = {"girl", "boy"})
    public void somebody(String name, int age) {
        System.out.println("姓名：" + name + " 年龄：" + age);
    }
}
