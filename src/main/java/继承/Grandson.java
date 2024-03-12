package 继承;

public class Grandson extends Child {
    public Grandson() {
        System.out.println("============= 子子类被初始化 =============");
    }

    public Grandson(String parent) {
        System.out.println("============= 子子类多参构造被初始化 =============");
        super.parent = parent;
    }

    @Override
    protected void incidental() {
        System.out.println("覆盖掉父类的方法");
    }
}
