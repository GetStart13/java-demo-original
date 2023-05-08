package 继承;

public class Grandson extends Child {

    @Override
    protected void incidental() {
        System.out.println("覆盖掉父类的方法");
    }
}
