package 泛型;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class MyGenericType<T> {


    public static void main(String[] args) {
        MyGenericType<String> genericType = new MyGenericType<>();
        genericType.testGetGenericTypeName();
        genericType.getName();
        testReturnType();
    }

    void testGetGenericTypeName() {

    }

    static Map<String, Object> testReturnType() {
        // HashMap<String, String> hashMap = new HashMap<>(); // 泛型类型不同，不能通过编译
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("泛型类型",
            "泛型的声明与返回值必须匹配，如果不匹配，将不能通过编译，即使使用 Object 作为泛型类型声明也一样，泛型不像类型，不具有自动向上转型的性质");
        return hashMap;
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
