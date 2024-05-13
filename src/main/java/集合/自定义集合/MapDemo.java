package 集合.自定义集合;

public class MapDemo {
    public static void main(String[] args) {
        MyHashMap<String, String> hashMap = new MyHashMap<>();
        hashMap.put("1", "2");
        hashMap.put("2", "2");
        hashMap.put("3", "2");
        hashMap.put("4", "2");
        hashMap.put("5", "2");
        hashMap.put("6", "2");
        hashMap.put("7", "2");
        hashMap.put("ddd", "2");
        hashMap.put("rrr", "2");
        hashMap.put("aaa", "2");
        hashMap.put("bbb", "2");
        hashMap.put("ccc", "2");
        hashMap.put("fff", "2");
        hashMap.put("yyy", "2");
        hashMap.put("ggg", "2");
        System.out.println("hashMap.size() = " + hashMap.size());
        MyHashMap.Node<String, String>[] table = hashMap.table;
        System.out.println("tale_length = " + table.length);
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                System.out.println(
                    "table[" + i + "] = " + table[i] + "--hash:" + table[i].hash + "--hashcode:" + table[i].getKey().hashCode());
                MyHashMap.Node<String, String> node = table[i].next;
                while (node != null) {
                    System.out.println(" -----> " + node + "--hash:" + node.hash + "--hashcode:" + node.getKey().hashCode());
                    node = node.next;
                }
            }
        }
    }
}
