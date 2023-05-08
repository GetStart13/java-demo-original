package 集合.map集合;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class myMap {
    public static void main(String[] args) {
    Map<String,Integer> hashMap=new HashMap<>();
    hashMap.put("zhang",34);
    hashMap.put("lisi",21);
    hashMap.put("wang",22);
    hashMap.put("wang",25); //键不允许重复，否则后一个值会覆盖前一个值
        //Set<String> strings = hashMap.keySet();
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry);
        }
        String str="asf(dffd";
        System.out.println(str.charAt(3));
        Set<String> set=new HashSet<>();
        set.add("zhang");
        set.add("lisi");
        set.add("wang");
        set.add("zhang");
        for (String s : set) {
            System.out.println("set:"+s);
        }
    }
}
