package 自定义注解;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 容器注解： 用来存放其它注解的地方，它本身也是一个注解。
 * 注解的 属性 也叫做成员变量。注解只有成员变量，没有方法。注解的成员变量在注解的定义中以“无形参的方法”形式来声明，
 * 其方法名定义了该成员变量的名字，其返回值定义了该成员变量的类型。
 * <p>
 * 在注解中定义属性时它的类型必须是 8 种基本数据类型外加 类、接口、注解及它们的数组。
 * <p>
 * 如果一个注解内仅仅只有一个名字为 value 的属性时，应用这个注解时可以不用写“value=”的前缀，
 * 直接将属性值填写到括号内： @Xxx("值")
 * 最后，还需要注意的一种情况是一个注解没有任何属性。那么在应用这个注解的时候，括号都可以省略。
 * <p>
 * 如果一个注解要在运行时被成功提取，那么设置保留时间 @Retention(RetentionPolicy.RUNTIME) 是必须的。
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME) // 设置容器保留时间，不能比容物短
public @interface MyAnnotations {
    MyAnnotate[] value();
}
