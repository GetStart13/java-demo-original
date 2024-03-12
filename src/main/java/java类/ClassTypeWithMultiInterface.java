package java类;

import java.io.Serializable;

public class ClassTypeWithMultiInterface implements Serializable, Comparable<String> {

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {
        ClassTypeWithMultiInterface multiInterface = new ClassTypeWithMultiInterface();
        if (multiInterface instanceof Serializable) {
            System.out.println("实例属于 Serializable 类型");
        }
        if (multiInterface instanceof Comparable<?>) {
            System.out.println("实例属于 Comparable 类型");
        }
    }
}
