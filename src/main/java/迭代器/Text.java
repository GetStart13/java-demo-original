package 迭代器;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Text {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(3);
        collection.add(2);
        Iterator<Integer> iterator = collection.iterator();// 定义一个迭代器
        while (iterator.hasNext()) {// 如果迭代器下一个索引不为空（有元素）
            System.out.println(iterator.next());// 则输出下一个元素
        }
    }
}
