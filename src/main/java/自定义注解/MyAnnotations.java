package 自定义注解;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 容器注解：用来存储重复注解的注解。
 * 注解的属性也叫做成员变量，它是一种“无形参方法”，没有方法体。其方法名定义了该成员变量的名字，其返回值定义了该成员变量的类型。
 * <br>
 * 在注解中定义的属性的类型可选范围是：8 种基本数据类型、类、接口、注解以及它们的数组。
 * <br>
 * 如果一个注解内只有一个名为 value 的属性，应用这个注解时可以不用写 “value=” 的前缀，
 * 可直接将属性值填写到括号内：@MyAnnotation("值")。
 * <br>
 * 如果一个注解没有任何属性，那么在应用这个注解时，括号也可以省略。
 * <br>
 * 如果一个注解要在运行时被成功提取，那么设置保留时间 @Retention(RetentionPolicy.RUNTIME) 是必须的。
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME) // 设置容器保留时间，不能小于被容纳注解的保留时间
public @interface MyAnnotations {
    MyAnnotation[] value();
}
