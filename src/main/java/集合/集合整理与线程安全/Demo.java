package 集合.集合整理与线程安全;

import java.util.*;
import java.util.concurrent.*;

/**
 * 非线程安全的集合，在 JUC 包下和 Collections 工具类下都有相应的解决方案
 */
public class Demo {
    /**
     * 常用集合类：
     * List ：ArrayList、LinkedList
     * Set ：HashSet、TreeSet、LinkedHashSet
     * Map ：HashMap、TreeMap、LinkedHashMap
     * ---
     * ArrayList ：
     * 底层数据结构是数组，
     * 单列，可重复，插入有序，查询快，修改（增删改）慢。按照索引查询时间复杂度为 O(1)
     * LinkedList ：
     * 底层数据结构是双链表，
     * 单列，可重复，由链表维持插入有序，修改快，查询慢。链表没有索引。
     * ---
     * HashSet ：
     * 底层数据结构是哈希表 HashMap，
     * 单列，不可重复，无序，允许一个值为空值
     * TreeSet ：
     * 基于 TreeMap，
     * 单列，不可重复，自然排序，不允许空值
     * LinkedHashSet ：
     * 继承 HashSet，基于 LinkedHashMap，所以数据结构是双链表 + 哈希表
     * 单列，不可重复，插入有序，允许一个值为空值
     * ---
     * HashMap ：
     * 底层数据结构是数组+链表+红黑树，
     * 双列，键 不可重复，无序，允许一个键值为空，高效，查询和插入时间复杂度都是 O(1)
     * TreeMap ：
     * 数据结构是红黑树，
     * 双列，键 不可重复，Key 自然排序，不允许空值，平均时间复杂度 O(logN)
     * LinkedHashMap ：
     * HashMap 的子类，加入了双链表用于保证插入顺序
     * 双列，键 不可重复，插入有序，允许一个键值为空
     */

    public static void main(String[] args) {

        // List 单列，插入有序，非线程安全，解决：两种方法
        ArrayList<Integer> arrayList = new ArrayList<>();
        // 方法 1：使用 JUC 包下的 CopyOnWriteArrayList 类
        CopyOnWriteArrayList<Integer> integers = new CopyOnWriteArrayList<>();
        // 方法 2：使用 Collections 工具类的 Collections.synchronizedList 方法修饰
        List<Integer> integers1 = Collections.synchronizedList(new ArrayList<>());
        // 双链表
        LinkedList<Object> linkedList = new LinkedList<>();


        HashSet<Integer> hashSet = new HashSet<>(); // 非线程安全
        // 1、线程安全，无序，ConcurrentSkipListSet 有序
        CopyOnWriteArraySet<Integer> arraySet = new CopyOnWriteArraySet<>();
        // 2、
        Set<Integer> set = Collections.synchronizedSet(new HashSet<>());
        // 3、底层数据结构是红黑树，
        TreeSet<Object> treeSet = new TreeSet<>();
        // 4、继承 HashSet，基于 LinkedHashMap，所以数据结构是双链表 + 哈希表
        LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<>();


        HashMap<String, String> hashMap = new HashMap<>(); // 非常线程安全
        hashMap.put("1", "1");
        hashMap.put("3", "1");
        hashMap.put("2", "1");
        // 无序
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println(entry);
        }
        // 1、线程安全，无序，ConcurrentSkipListMap 有序
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        // 2、
        Map<String, String> stringMap = Collections.synchronizedMap(new HashMap<>());
        // 3、数据结构是红黑树，
        TreeMap<Object, Object> treeMap = new TreeMap<>();
        // 4、HashMap 的子类，加入了双链表用于保证插入顺序
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("1", "1");
        linkedHashMap.put("3", "1");
        linkedHashMap.put("2", "1");
        // 有序
        for (Map.Entry<Object, Object> entry : linkedHashMap.entrySet()) {
            System.out.println(entry);
        }

    }
}
