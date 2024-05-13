package 反射.反射越过泛型检查;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // 往 ArrayList<Integer> 集合中添加一个字符串
        // 新建一个 ArrayList 对象
        ArrayList<Integer> array = new ArrayList<>();

        // 通过对象获取该类的对象属性，向下转型
        Class<?> ar = array.getClass();

        // 获取类的公共成员方法
        Method ad = ar.getMethod("add", Object.class);

        // 赋值
        ad.invoke(array, "hello");
        ad.invoke(array, "world");
        ad.invoke(array, "java");

        System.out.println(array);
    }
}
