package 集合.自定义集合;

import java.util.Map;
import java.util.Objects;

public class MyHashMap<K, V> {
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    //声明node内部类，用来存放链表节点
    public static class Node<K, V> implements Map.Entry<K, V> {
        public int hash;
        final K key;
        V value;
        public MyHashMap.Node<K, V> next;

        Node(int hash, K key, V value, MyHashMap.Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this) {
                return true;
            }

            return o instanceof Map.Entry<?, ?> && Objects.equals(key, ((Map.Entry<?, ?>) o).getKey()) &&
                Objects.equals(value, ((Map.Entry<?, ?>) o).getValue());
        }
    }

    public transient MyHashMap.Node<K, V>[] table;  //数组类型的链表

    transient int size; //记录长度

    static final float DEFAULT_LOAD_FACTOR = 0.75f; //默认负载因数
    final float loadFactor; //负载因数
    int threshold;  //容量临界值
    int MAXIMUM_CAPACITY = 1 << 30;

    public MyHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    final int hash(Object key) { //返回hashcode
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16); //异或运算，右移16位是因为它会获得一个17位的hashcode，
        // 移了16位后原数值只剩1位可能不为0的数参与异或
    }

    public int size() {
        return size;
    }

    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        Node<K, V>[] tab = table;
        Node<K, V> p;
        int n, i;
        if (tab == null || (n = tab.length) == 0) {
            n = (tab = resize()).length; //如果原链表数组为空，初始化该容量
        }
        if ((p = tab[i = (n - 1) & hash]) == null) { //如果数组的该位置没有元素，则在 插入新节点，存值位置：(n - 1) & hash
            tab[i] = newNode(hash, key, value, null);
        } else {    // 数组该位置已经有元素
            MyHashMap.Node<K, V> e;
            K k;
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))) {
                e = p; //如果键相同，覆盖键
            } else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) { //如果键不相同，该位置链表的下一个节点为空，则将节点直接插入下一个节点
                        p.next = newNode(hash, key, value, null);
                        break;
                    }
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                        break;  //如果键相同，覆盖键
                    }
                    p = e;  //把p的下一个节点重定向给到p
                }
            }
            if (e != null) {    //如果键相同，跳转到这里，重新赋值
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null) {
                    e.value = value;
                }
                return oldValue;
            }
        }
        if (++size > threshold) {   //size++：统计长度+1，如果尺寸达到了阈值，调用扩容方法扩容
            resize();
        }
        return null;
    }

    final Node<K, V>[] resize() {   //扩容
        Node<K, V>[] newTab, oldTab;
        int oldCap, newCap, oldThr, newThr;
        oldTab = table;
        oldThr = threshold;
        newCap = newThr = 0;
        oldCap = table == null ? 0 : table.length;  //旧容器如果为空，赋值0容器容量，如果不为空，赋值原始容量
        if (oldCap > 0) {
            if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap >= DEFAULT_INITIAL_CAPACITY) {
                newThr = oldThr << 1;   //如果新容量（旧容量*2）小于最大容量 且 旧容量大于默认容量，则 将旧阈值乘以2然后赋值给新阈值
            }
        } else {               // 如果旧容量不大于0（意思是空值，map为空）
            newCap = DEFAULT_INITIAL_CAPACITY; //新容量等于默认容量
            newThr = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY); //新阈值等于默认容量 乘以 默认负载系数
        }
        threshold = newThr; //重新赋值阈值

        newTab = (MyHashMap.Node<K, V>[]) new MyHashMap.Node[newCap]; // 初始化新的链表数组

        table = newTab; // table 指向newTab数组，对于数组来说，这是地址引用，不是赋值。

        if (oldTab != null) { //如果就容器不为空，就要把旧数组里面的值复制给新数组
            for (int j = 0; j < oldCap; ++j) {  //遍历旧数组
                MyHashMap.Node<K, V> e;
                if ((e = oldTab[j]) != null) { //如果第j个数据不为空，就用e存入原来的值，然后将该数据置空
                    oldTab[j] = null;
                    if (e.next == null) { //如果e的下一个节点为空，证明该位置只有一个节点，则存入e
                        newTab[e.hash & (newCap - 1)] = e;
                    } else { // 如果该位置不止一个节点
                        MyHashMap.Node<K, V> loHead = null, loTail = null;  //低位节点
                        MyHashMap.Node<K, V> hiHead = null, hiTail = null;  //高位节点
                        MyHashMap.Node<K, V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null) {
                                    loHead = e;
                                } else {
                                    loTail.next = e;
                                }
                                loTail = e;
                            } else {
                                if (hiTail == null) {
                                    hiHead = e;
                                } else {
                                    hiTail.next = e;
                                }
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead; //低位插入节点
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead; // 高位插入节点
                        }
                    }
                }
            }
        }
        return newTab;
    }

    MyHashMap.Node<K, V> newNode(int hash, K key, V value, MyHashMap.Node<K, V> next) {
        return new MyHashMap.Node<>(hash, key, value, next);
    }
}
