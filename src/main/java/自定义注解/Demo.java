package 自定义注解;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) {
        try {
            // 反射获取Person的Class实例
            Class<?> aClass = Class.forName("自定义注解.Person");
            // 获取对象实例
            Object obj = aClass.getConstructor().newInstance();

            // 获取 somebody() 方法的Method实例，name 指定方法
            Method somebody = aClass.getMethod("somebody", String.class, int.class);
            // 执行该方法
            somebody.invoke(obj, "周星驰", 23);
            // 调用自定义方法
            showAnnotation(somebody);

            // 获取 empty() 方法的Method实例
            Method empty = aClass.getMethod("empty");
            // 调用自定义方法
            showAnnotation(empty);
            empty.invoke(obj);

        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException
                 | IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showAnnotation(Method method) {

        // 判断 somebody() 方法是否包含MyAnnotation注解，未设置容器情况 ↓
        if (method.isAnnotationPresent(MyAnnotate.class)) {
            System.out.println("--------------- MyAnnotate.class ---------------");
            // 获取该方法的 MyAnnotate 注解实例，需要 @Retention 的值为runtime
            MyAnnotate annotation = method.getAnnotation(MyAnnotate.class);
            // 获取 myAnnotation的值，并打印出来
            String[] values = annotation.values();
            for (String value : values) {
                System.out.println("自定义注解的所有属性值：" + value);
            }
        }

        // 判断 somebody() 方法是否包含MyAnnotation注解，但是 MyAnnotate 被设置了容器，
        // 所以不能直接获取到 MyAnnotate 的类型，要通过容器获取 ↓
        if (method.isAnnotationPresent(MyAnnotations.class)) {
            System.out.println("-------------- MyAnnotations.class --------------");
            // 获取该方法上的 MyAnnotations 注解实例
            MyAnnotations annotation = method.getAnnotation(MyAnnotations.class);
            // 通过容器 MyAnnotations 获取容物 MyAnnotate 的所有值
            MyAnnotate[] myAnnotates = annotation.value();
            // 循环遍历打印所有值
            for (MyAnnotate myAnnotate : myAnnotates) {
                String[] values = myAnnotate.values();
                for (String value : values) {
                    System.out.println("自定义注解 MyAnnotate 的所有属性值：" + value);
                }
            }
            System.out.println("-------------- end --------------");
        }
        // 获取方法上的所有注解，并打印出来
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("方法上的所有注解为：" + annotation);
        }
    }
}
