package 集合.map集合;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapGenerally {
    public static void main(String[] args) {
        MapGenerally i = new MapGenerally();
        treeMap();
        hashMap();
        // concurrentHashMap();
        linkHashMap();
        linkedHashSet();

        i.removeTest();
    }

    void removeTest() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "1");
        hashMap.put("2", "1");
        hashMap.remove("2");
        hashMap.remove(null);
        hashMap.remove("2", "1");
        System.out.println(hashMap);
    }

    /**
     * treemap 排序问题，升序和降序
     */
    public static void treeMap() {

        // 按 Key 升序，按 Value 降序，不允许 Key 空值

        // TreeMap<String, String> map = new TreeMap<>(); // TreeMap 默认升序排序，排序按 Key 值排序
        // 下面是 TreeMap 降序排序，已有实现接口：Comparator.reverseOrder()（升序反转便是降序）
        TreeMap<String, String> map = new TreeMap<>((c1, c2) -> c2.compareTo(c1));

        //map.put(null, "fefs");
        //map.put(null, "fefs1");
        map.put("daw", "fefs");
        map.put("daw", "fefs2");
        map.put("frsg", "sfe");
        map.put("sdfase", "dade");
        map.put("hfdd", "vrsv");
        map.put("xv", "sdffs");
        map.put("fs", "acxas");
        map.put("vs", "zczse");
        map.put("vsd", "asccs");
        map.put("ava", "acaew");
        map.put("vdse", "sxccasc");
        map.put("vsdse", "ddzc");
        map.put("esce", "ysggvgs");
        map.put("tafe", "fgaxs");
        map.put("ade", "aee");
        map.put("aceq", "acsq");

        System.out.println("TreeMap: " + map);

        // 获取 treemap 的 entry 的 set 集合
        Set<Map.Entry<String, String>> entries = map.entrySet();
        // 把 set 集合转换成 ArrayList
        ArrayList<Map.Entry<String, String>> entries1 = new ArrayList<>(entries);
        // 调用 List 的 sort 方法，通过比较器降序排序，如果 c1，c2 正向就是升序：c1.getValue().compareTo(c2.getValue())
        entries1.sort((c1, c2) -> c2.getValue().compareTo(c1.getValue()));
        System.out.println("entries1 = " + entries1);
    }

    /**
     * 无序
     */
    public static void hashMap() {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put(null, "gfgs");
        hashMap.put(null, "1gfgs");
        hashMap.put("afef", "gfgs");
        hashMap.put("ad", "srgr");
        hashMap.put("zczdv", "gdfgfgs");
        hashMap.put("vdz", "sgdgr");
        hashMap.put("sca", "afefr");
        hashMap.put("acsae", "erarf");
        hashMap.put("czs", "cad");
        hashMap.put("xzd", "afedf");
        hashMap.put("zsd", "afee");
        hashMap.put("zscf", "afee");

        // hashmap 是无序的键值对集合，键不能重复，键为位置由它的 hashcode 决定
        System.out.println("hashMap: " + hashMap);
    }

    /**
     * 线程安全，推荐使用
     */
    public static void concurrentHashMap() {

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();// 还可以用 Collections 的 synchronize 方法修饰
        map.put("aaa", "bbb");
        System.out.println(map);
    }

    /**
     * 插入顺序有序
     */
    public static void linkHashMap() {

        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();

        hashMap.put(null, "aefae");
        hashMap.put(null, "aefae3");
        hashMap.put("fesfad", "aefae");
        hashMap.put("fesfad", "aefae---2");
        hashMap.put("dsae", "vsr");
        hashMap.put("zczdv", "zdaq");
        hashMap.put("ade", "frgcs");
        hashMap.put("sdvg", "saas");
        hashMap.put("ader", "qddd");
        hashMap.put("tryrth", "gsdrg");
        hashMap.put("fxrg", "rxf");
        hashMap.put("acfvbf", "rrxx");
        hashMap.put("adf", "grrs");

        System.out.println("linkedHashMap = " + hashMap);
    }

    /**
     * 插入有序
     */
    public static void linkedHashSet() {
        LinkedHashSet<String> hashSet = new LinkedHashSet<>();

        hashSet.add(null);
        hashSet.add(null);
        hashSet.add("efwe");
        hashSet.add("efwe");
        hashSet.add("etsv");
        hashSet.add("aefez");
        hashSet.add("aeeq");
        hashSet.add("vzq");
        hashSet.add("cder");
        hashSet.add("aasddf");
        hashSet.add("xxcd");
        hashSet.add("efzz");
        hashSet.add("qczsd");
        hashSet.add("zfvd");
        hashSet.add("bdf");
        hashSet.add("adrr");

        System.out.println("hashSet = " + hashSet);

        hashSet.remove("element");
    }
}
