package 自定义注解;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationDemo {
    public static void main(String[] args) {
        try {
            // 反射获取 Person 的 Class 实例
            Class<?> personClass = Class.forName("自定义注解.Person");

            // 获取方法实例
            Method somebody = personClass.getMethod("somebody", String.class, int.class);
            // 执行自定义注解逻辑
            showAnnotation(somebody);

            // 获取方法实例
            Method empty = personClass.getMethod("nobody");
            // 执行自定义注解逻辑
            showAnnotation(empty);

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void showAnnotation(Method method) {

        // 判断方法上是否使用了 MyAnnotation 注解，如果注解被多次使用，将变为容器注解，此判断将为 false。
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            // 获取该方法的 MyAnnotation 注解实例，需要注解的保留时间 @Retention 的值为 runtime。
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            // 获取 myAnnotation 的 values 值，并打印
            String[] values = annotation.values();
            System.out.println("打印 MyAnnotation 的 values：");
            for (String value : values) {
                System.out.println(" - " + value);
            }
        }

        // 判断方法上是否使用了 MyAnnotation 注解，如果注解被多次使用，将变为容器注解 MyAnnotations，此判断将为 true。
        else if (method.isAnnotationPresent(MyAnnotations.class)) {
            // 获取该方法上的 MyAnnotations 注解实例
            MyAnnotations annotation = method.getAnnotation(MyAnnotations.class);
            // 通过容器 MyAnnotations 获取 MyAnnotation 的所有值
            MyAnnotation[] myAnnotations = annotation.value();
            // 循环打印
            System.out.println("打印 MyAnnotations：");
            int i = 1;
            for (MyAnnotation myAnnotation : myAnnotations) {
                String[] values = myAnnotation.values();
                System.out.println("第 " + i++ + " 个 MyAnnotation 的 values：");
                for (String value : values) {
                    System.out.println(" - " + value);
                }
            }
        }

        // 通过 getAnnotationsByType 方法获取方法上的 MyAnnotation 注解，不论注解被使用了一次还是多次
        MyAnnotation[] myAnnotations = method.getAnnotationsByType(MyAnnotation.class);
        // 循环打印
        System.out.println("通过 getAnnotationsByType 方法获取 MyAnnotation 数组：");
        int i = 1;
        for (MyAnnotation myAnnotation : myAnnotations) {
            String[] values = myAnnotation.values();
            System.out.println("第 " + i++ + " 个 MyAnnotation 注解的 values：");
            for (String value : values) {
                System.out.println(" - " + value);
            }
        }

        // 获取方法上的所有注解
        Annotation[] annotations = method.getAnnotations();
        System.out.println("方法 [" + method.getName() + "] 上的所有注解为：");
        for (Annotation annotation : annotations) {
            System.out.println(" - " + annotation);
        }

        System.out.println("-------------- end --------------");
    }
}
