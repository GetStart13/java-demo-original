package Lambda表达式和方法引用;

import java.lang.reflect.Method;

public class MethodReference {
    public static void main(String[] args) {
        MyFunction<String, Integer> myFunction = String::length;
        Class<?>[] parameterTypes = getParameterTypes(myFunction);
        for (Class<?> parameterType : parameterTypes) {
            System.out.println(parameterType.getName());
        }
    }

    public static Class<?>[] getParameterTypes(MyFunction<?, ?> function) {
        try {
            Method method = function.getClass().getDeclaredMethod("apply", Object.class);
            return method.getParameterTypes();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return new Class[0];
        }
    }

    @FunctionalInterface
    interface MyFunction<T, R> {
        R apply(T t);
    }
}


