package test_temp;


import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * this is notes , you can see it when you put the mouse on the method or the class
 */
public class Temp {


    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();
        map.put("KeyOne", "Value1");
        map.put("KeyTwo", "Value2");
        map.put("KeyThree", "Value3");
        map.put("KeyFour", "Value4");
        map.put("KeyFour", "Value5");
        map.put("1", "Value5");
        map.put("2", "Value5");
        map.put("3", "Value5");
        map.put("4", "Value5");
        map.put("6", "Value5");
        map.put("7", "Value5");
        map.put("8", "Value5");
        map.put("9", "Value5");
        map.put(null, "Value1");
        map.put("11", "Value5");
        map.put("22", "Value5");
        map.put("33", "Value5");
        map.put("44", "Value5");
        map.put("55", "Value5");
        map.put("66", "Value5");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        entries.size();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry);
        }
        map.size();
        System.out.println("map.get(\"KeyTwo\") = " + map.get("KeyTwo"));
        System.out.println("map.hashCode() = " + map.hashCode());

        test();
    }

    static void test() {
        Field[] fields = Object.class.getDeclaredFields();
        System.out.println(Arrays.toString(fields));
    }

}

