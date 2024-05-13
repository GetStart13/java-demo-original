package 集合.List集合;

import java.util.ArrayList;

/**
 * List, set, map 都是接口，不能直接使用，需要调用它的具体实现类
 */

public class ListOperators {
    public static void main(String[] args) {

        // 创建集合
        ArrayList<String> array = new ArrayList<>();

        // 添加元素：
        array.add("hello");
        array.add("world");
        array.add("java");
        System.out.println(array);

        // 删除元素：
        array.remove("hello");// 删除指定元素（第一个出现的该元素）
        System.out.println(array);
        array.remove(0);// 删除指定位置的元素（索引）
        System.out.println(array);
        // IndexOutOfBoundsException，索引越界，报错！
        //array.remove(3);
        //System.out.println(array);

        // 修改元素：
        array.set(0, "javaee");
        System.out.println(array);
        // 查找元素：
        // 根据位置查找
        System.out.println(array.get(0));
        // 根据名称查找索引位置
        System.out.println(array.indexOf("javaee"));


        // 在指定位置插入元素
        array.add("new");
        array.add(1, "was add");
        System.out.println(array);
    }
}
