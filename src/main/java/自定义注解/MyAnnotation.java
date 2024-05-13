package 自定义注解;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 注解是一系列元数据，它提供数据用来解释程序代码，但是注解并非是它所解释代码本身的一部分。
 * 注解对于代码的运行效果没有直接影响。
 * 注解的作用可以用“标签”来形容描述，相当于是给某一个东西贴上一个标记，那么管理者就可以对被标记的东西做一些处理，
 * 当然也可以定义不处理，这些都是由管理者控制的。
 * <br>
 * 也就是说，你定义了注解，也使用了注解，此时注解还没有任何作用，你还需要提供相应代码提取并处理注解信息，
 * 这些提取和处理注解的代码统称为 APT（Annotation Processing Tool）。
 * <br>
 * 注解有许多用处，主要如下：
 * <ul>
 * <li>提供信息给编译器： 编译器可以利用注解来探测错误和警告信息。
 * <li>编译阶段时的处理： 软件工具可以用来利用注解信息来生成代码、Html 文档或者做其它相应处理。
 * <li>运行时的处理： 某些注解可以在程序运行的时候接受代码的提取。
 * </ul>
 * 注解有什么用？给谁用？答：给编译器或者 APT 用。
 * <br>
 * <br>
 * 根据注解是否包含成员变量，可以分为如下两类：
 * <ul>
 * <li>标记注解：没有定义成员变量的注解类型被称为标记注解。这种注解仅利用自身的存在与否来提供信息，如 @Override、@Test 等都是标记注解。
 * <li>元数据注解：包含成员变量的注解，因为它们可以接受更多的元数据，所以也被称为元数据注解。
 * </ul>
 * 元注解是可以注解到注解上的注解。
 * java 中有五种元注解：@Retention、@Inherited、@Documented、@Target、@Repeatable（jdk1.8 新增）
 * <br>
 * <br>{@code @Retention}：
 * <br>声明注解的保留位置（枚举 RetentionPolicy），RetentionPolicy 可选值：
 * <ul>
 * <li>SOURCE：注解仅存在于源码中，在 class 字节码文件中不存在。
 * <li>CLASS：默认的保留策略，注解在 class 字节码文件中存在，但运行时无法获得。
 * <li>RUNTIME：注解在 class 字节码文件中存在，在运行时可以通过反射获取。
 * </ul>
 *
 * {@code @Inherited}：
 * <br>声明此注解可被继承。如果一个类A使用此注解，则类A的子类也将继承使用此注解。
 * <br>
 *
 * <br>{@code @Target}：
 * <br>声明注解范围（枚举 ElementType），ElementType 可选值：
 * <ul>
 * <li>TYPE：类型（接口、类、枚举、注解）。
 * <li>FIELD：字段。
 * <li>METHOD：方法。
 * <li>PARAMETER：方法参数。
 * <li>CONSTRUCTOR：构造函数。
 * <li>LOCAL_VARIABLE：局部变量。
 * <li>ANNOTATION_TYPE：注解。
 * <li>PACKAGE：包。
 * </ul>
 *
 * {@code @Documented}：
 * <br>声明注解能够被 javadoc 等识别，用于生成说明文档。
 * <br>
 *
 * <br>{@code @Repeatable}：
 * <br>表明注解在同一个声明上可重复使用。
 * <br>
 */

// value 指明容器注解：MyAnnotations，容器注解的保留时间 @Retention 必须要比被容纳注解的保留时间更长，
// 如果一个注解A指定了容器注解As，如果此注解A在同一个声明上被多次使用，则通过 getAnnotation 方法获取到的不是注解A，而是它的容器注解As，
// getAnnotationsByType 方法可以直接返回注解数组，不论注解出现一次还是多次。
@Repeatable(value = MyAnnotations.class)
// @Retention 保留时间，值为 runtime 时，注解信息可以被通过反射获取到，runtime 表示运行时保留，如果不设置，运行时该注解不生效
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String[] values() default "unknown"; // default 设置默认值，如果没有，在使用注解时必须赋值

}

