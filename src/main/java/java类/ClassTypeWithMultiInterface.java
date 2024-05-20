package java类;

import java.io.Serializable;

public class ClassTypeWithMultiInterface implements Serializable, Comparable<String> {

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {
        ClassTypeWithMultiInterface multiInterface = new ClassTypeWithMultiInterface();
        System.out.println("=============== 实例实现多个接口，则属于任何一接口的实例对象 ===============");
        System.out.println("实例属于 Serializable 类型？" + (multiInterface instanceof Serializable));
        System.out.println("实例属于 Comparable 类型？" + (multiInterface instanceof Comparable<?>));
        System.out.println("=============== 类的数组不属于它的类实例，而是属于它的类数组实例 ===============");
        System.out.println("类的数组对象是否属于它的类实例？" + ifClassArrayInstanceOfClass((new Integer[] {1, 2, 3})));
    }

    private static boolean ifClassArrayInstanceOfClass(Object obj) {
        return obj instanceof Integer;
    }
}
