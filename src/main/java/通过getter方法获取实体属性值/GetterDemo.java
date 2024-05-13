package 通过getter方法获取实体属性值;


import 数据库操作.entity.Student;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p> 2024/5/13 </p>
 *
 * @author Fqq
 */
public class GetterDemo {
    public static void main(String[] args) {
        introspectorTest();
        propertyGetTest();
        String name = extractName(User::getName);
        System.out.println(name);
    }

    static void introspectorTest() {
        try {
            Student student = new Student();
            student.setName("myName");
            BeanInfo beanInfo = Introspector.getBeanInfo(Student.class);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                if (!"class".equals(propertyDescriptor.getName())) {
                    Method readMethod = propertyDescriptor.getReadMethod();
                    Object methodValue = readMethod.invoke(student);
                    System.out.println(methodValue);
                }
            }
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过 PropertyDescriptor 传入属性名来获取属性的读写方法
     */
    static void propertyGetTest() {
        try {
            Student student = new Student();
            student.setName("stu");
            PropertyDescriptor methodDescriptor = new PropertyDescriptor("name", Student.class);
            Object methodValue = methodDescriptor.getReadMethod().invoke(student);
            System.out.println(methodValue);
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过方法引用获取方法名
     * 请注意，此方法在 mybatis plus 中有完善的方法，生产代码不能调用此测试代码
     *
     * @param lambda 方法引用
     * @return 属性名
     */
    public static String extractName(GetterFunction<User, String> lambda) {
        try {
            Method writeReplace = lambda.getClass().getDeclaredMethod("writeReplace");
            SerializedLambda serializedLambda = (SerializedLambda) writeReplace.invoke(lambda);
            String methodName = serializedLambda.getImplMethodName();
            return methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
