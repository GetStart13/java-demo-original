package 泛型;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class MyGenericType<T> {


    public static void main(String[] args) {
        MyGenericType<String> genericType = new MyGenericType<>();
        genericType.testGetGenericTypeName();
        genericType.getName();

    }

    void testGetGenericTypeName() {

    }

    void getName() {
        class InnerClass extends MyGenericType<T> {
        }
        Type type = InnerClass.class.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] types = parameterizedType.getActualTypeArguments();
        System.out.println(types[0]);
        System.out.println(type);
    }
}
