package 反射.反射基础练习;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 通过类名可以调用类中静态修饰的成员方法
 */
public class 反射 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        // 1、通过类的属性获取类的对象
        Class<Student> reflect1 = Student.class;

        // 2、通过调用对象的 getClass() 方法获取类的对象，返回该对象所属类对应的 Class 对象，所有的 java 对象都可以使用该方法
        Student student = new Student();
        student.setId(1);
        student.setName("名字");
        Class<? extends Student> reflect2 = student.getClass();
        // 获取声明的成员属性的值
        try {
            Field getName = reflect2.getDeclaredField("name");
            // 访问私有变量
            getName.setAccessible(true);
            // 获取值
            Object name = getName.get(student);
            System.out.println(name);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        // 3、使用 Class 类中的静态方法 forName(String name)，用于从配置文件读取类
        Class<?> reflect3 = Class.forName("反射.反射基础练习.Student");

        //获取构造方法
        Constructor<?> constructor = reflect3.getConstructor();

        // 获取对象
        Object instance = constructor.newInstance();

        // 按名字获取成员方法
        Method publicMethod = reflect3.getMethod("publicMethod");
        // 调用该方法
        publicMethod.invoke(instance);

        // 有参成员方法
        Method publicMethod1 = reflect3.getMethod("publicMethod", String.class);
        // 援用对象、传参，publicMethod1 方法被执行
        publicMethod1.invoke(instance, "周星驰");

        // 获取方法参数和参数名（参数名只能获取序号名字，不能获取真实名字）
        Parameter[] parameters = publicMethod1.getParameters();
        for (Parameter parameter : parameters) {
            String name = parameter.getName();
            Class<?> type = parameter.getType();
            System.out.println("参数名: " + name);
            System.out.println("参数类型: " + type);
        }

        // 拿到该类声明的所有方法，不包括继承的方法
        Method[] methods = reflect3.getDeclaredMethods();
        // 虽然可以拿到私有方法，但是不可以直接访问，需要修改访问权限
        for (Object method : methods) {
            System.out.println(method);
        }

        // getDeclaredMethod() 方法为返回指定成员方法的对象，包括私有
        Method privateMethod = reflect3.getDeclaredMethod("privateMethod", String.class, int.class);

        // 修改访问权限
        privateMethod.setAccessible(true);
        // 调用方法
        Object zhouJieLun = privateMethod.invoke(instance, "周杰伦", 10);
        // 有返回值，控制台输出对象
        System.out.println(zhouJieLun);

        // 父类方法可以 invoke 子类对象
        Class<People> peopleClass = People.class;
        Method publicMethod2 = peopleClass.getMethod("publicMethod");
        publicMethod2.invoke(instance);

        // 子类方法不可以 invoke 父类对象
        Class<Child> childClass = Child.class;
        Method publicMethod3 = childClass.getMethod("publicMethod");
        publicMethod3.invoke(instance);
    }
}
