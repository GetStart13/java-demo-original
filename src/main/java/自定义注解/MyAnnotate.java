package 自定义注解;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 注解是一系列元数据，它提供数据用来解释程序代码，但是注解并非是所解释的代码本身的一部分。
 * 注解对于代码的运行效果没有直接影响。
 * 注解的作用可以用“标签”来形容描述，相当于是给某一个东西贴上一个标记，那么管理者就可以对被标记的东西做一些处理，
 * 当然也可以定义不处理，这些都是由开发者设置的
 * 注解有许多用处，主要如下：
 * - 提供信息给编译器： 编译器可以利用注解来探测错误和警告信息
 * - 编译阶段时的处理： 软件工具可以用来利用注解信息来生成代码、Html文档或者做其它相应处理。
 * - 运行时的处理： 某些注解可以在程序运行的时候接受代码的提取
 * <p>
 * 根据注解是否包含成员变量，可以分为如下两类：
 * 标记注解：没有定义成员变量的注解类型被称为标记注解。这种注解仅利用自身的存在与否来提供信息，如前面介绍的 @Override、@Test 等都是标记注解。
 * 元数据 注解：包含成员变量的注解，因为它们可以接受更多的元数据，所以也被称为元数据注解。
 * <p>
 * -------------------------------------------------------------------------------
 * 当开发者使用了Annotation 修饰了类、方法、Field 等成员之后，这些 Annotation 不会自己生效，
 * 必须由开发者提供相应的代码来提取并处理 Annotation 信息。
 * 这些提取和处理 Annotation 的代码统称为 APT（Annotation Processing Tool)。
 * 那么，注解有什么用？给谁用？ 答案：给 编译器或者 APT 用的。
 * -------------------------------------------------------------------------------
 * 元注解是可以注解到注解上的注解
 * java中有 五 种元注解：@Retention、@Inherited、@Documented、@Target、@Repeatable（ jdk1.8 新加进来 ）
 * <p>
 * Retention ：
 * 注解的保留位置（枚举RetentionPolicy），RetentionPolicy可选值：
 * --SOURCE：注解仅存在于源码中，在class字节码文件中不包含
 * --CLASS：默认的保留策略，注解在class字节码文件中存在，但运行时无法获得
 * --RUNTIME：注解在class字节码文件中存在，在运行时可以通过反射获取到
 * <p>
 * Inherited：
 * 声明子类可以继承此注解，如果一个类A使用此注解，则类A的子类也继承此注解
 * <p>
 * Target：
 * 用来声明注解范围（枚举ElementType），ElementType可选值：
 * --TYPE：接口、类、枚举、注解
 * --FIELD：字段、枚举的常量
 * --METHOD：方法
 * --PARAMETER：方法参数
 * --CONSTRUCTOR：构造函数
 * --LOCAL_VARIABLE：局部变量
 * --ANNOTATION_TYPE：注解
 * --PACKAGE：包
 * <p>
 * Documented：
 * 声明注解能够被javadoc等识别，用于生成说明文档
 * <p>
 * Repeatable ：
 * 可重复
 * <p>
 * ------------------------------------------------------------------------------
 * Annotation在反射函数中的使用示例
 */

@Repeatable(value = MyAnnotations.class)  /* MyAnnotations.class 是指明容器注解是： MyAnnotations ,
                                             容器保留的时间 @Retention 必须要比被容纳的注解的时间长 ，
                                             如果设置了容器注解，那么被容物注解标注的属性不再属于容物类型，
                                             而是属于容器类型！
                                           */
@Retention(RetentionPolicy.RUNTIME) // @Retention 保留时间，值为runtime时，注解信息可以被通过反射获取到，runtime表示运行时保留，如果不设置，运行时该注解不生效
public @interface MyAnnotate {

    String[] values() default "unKnow"; // default 设置默认值，如果没有，在使用注解时必须赋值

}

