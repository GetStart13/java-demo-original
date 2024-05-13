package 集合.自定义集合;

import java.util.Arrays;

/**
 * 自定义 ArrayList 集合，参考环境 jdk 1.8
 *
 * @param <T>
 */
public class MyArrayList<T> {
    private static final Object[] EMPTY_ELEMENT_DATA = {};
    transient Object[] element;
    private static int size;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public MyArrayList() {
        this.element = EMPTY_ELEMENT_DATA;// 初始化数组，元素为空
    }

    public void add(T t) {
        changeCapacitySize(size + 1);// 对数组扩容，+1 操作
        element[size++] = t;// 先取得 element[size] 赋值,而后 size++
    }

    private void changeCapacitySize(int minCapacity) {
        int oldCapacity = element.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);// 新容器长度为旧容器的 1+1/2 倍
        if (newCapacity - minCapacity < 0)// 判断,如果数值过大溢出会导致此判断为正
        {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0)//判断
        {
            newCapacity = hugeCapacity(minCapacity);
        }
        // minCapacity is usually close to size, so this is a win, 初始的容器值通常接近大小，这是常规现象
        //element = Arrays.copyOf(element, newCapacity);//调用copy方法，将原数组复制到新数组，新数组长度被改变
        //element=copyOf(element,newCapacity);
        element = myCopyOf(element, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow 数值过大溢出
        {
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }

    private <E> E[] myCopyOf(E[] element, int newLength) {
        @SuppressWarnings("unchecked")// 不检查警告
        E[] copy = (E[]) new Object[newLength];// 新创建一个数组，通过两个数组的复制实现数组扩容的结果
        System.arraycopy(element, 0, copy, 0,// copy 为 native 方法(非java语言编写)
            Math.min(element.length, newLength));// 取最小，防止溢出
        return copy;
    }

    public T get(int index) {
        @SuppressWarnings("unchecked")
        T eee = (T) element[index];
        return eee;
    }

    public int size() {
        return size;
    }

    public int length() {//测试得出数组长度与集合长度并不相同。。。
        return element.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(element);
    }
}
