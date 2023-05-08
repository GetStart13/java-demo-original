package 通过getter方法获取实体属性值;

import 学生信息管理系统.Student;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetterDemo {
    public static void main(String[] args) {
        testIntrospector();
        testGetOne();
    }

    static void testIntrospector() {
        try {
            Student student = new Student();
            student.setName("myName");
            BeanInfo beanInfo = Introspector.getBeanInfo(Student.class);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                if (!"class".equals(propertyDescriptor.getName())) {
                    Method readMethod = propertyDescriptor.getReadMethod();
                    Object invoke = readMethod.invoke(student);
                    System.out.println(invoke);
                }
            }
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static void testGetOne() {
        try {
            Student student = new Student();
            student.setName("stu");
            PropertyDescriptor descriptor = new PropertyDescriptor("name", Student.class);
            Object invoke = descriptor.getReadMethod().invoke(student);
            System.out.println(invoke);
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
