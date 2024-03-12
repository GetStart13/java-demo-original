package test_temp;


import 构造方法.Student;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

public class TempDemo1 {

    public static void main(String[] args) {
        TempDemo1 demo1 = new TempDemo1();
        demo1.test();
        demo1.testIntParse();
        demo1.getMethod();
    }

    void test() {
        try {
            testException();
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            String string = stringWriter.toString();
            System.out.println(string);
        }
    }

    void testException() {
        String msg = "someException";
        throw new RuntimeException("throw msg: " + msg);
    }

    void testIntParse() {
        String str = "0000000000000001";
        System.out.println(str.length());
    }

    void getMethod() {
        try {
            Method method = Student.class.getMethod("getName");
            String fieldName = getFieldName(method);
            System.out.println(fieldName);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFieldName(Method method) {
        try {
            Class<?> clazz = method.getDeclaringClass();
            BeanInfo info = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] props = info.getPropertyDescriptors();
            for (PropertyDescriptor pd : props) {
                if (method.equals(pd.getWriteMethod()) || method.equals(pd.getReadMethod())) {
                    System.out.println(pd.getDisplayName());
                    return pd.getName();
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}
