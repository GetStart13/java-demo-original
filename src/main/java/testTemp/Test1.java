package testTemp;


public interface Test1<V> {
    int a=1;
    int test();
    boolean com(V v);
    default void show(){
        System.out.println("------------");
    }
}
