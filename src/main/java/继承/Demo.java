package 继承;

public class Demo {
    public static void main(String[] args) {
        testFiled();
        testMethod();
        testPriority();
    }

    static void testFiled() {
        Parent parent = new Child();

        parent.parent = "parent through field to set parent";// 直接赋值给成员变量，哪一个类型声明的，就会赋值给哪一个
        parent.setParent("parent through method to set parent");// 不会覆盖掉 parent.parent，因为操作的不是同一个成员属性

        System.out.println("\n直接访问，访问的是声明类型的成员变量，并非实例化的子类: \n" + parent.parent);
        System.out.println("通过方法访问，通过子类重写的 set 方法设置成员变量的值，调用的是子类的方法，因此，通过方法访问得到的值与直接访问得到的值不同: \n"
                + parent.getParent() + "\n");


        Child child = (Child) parent;// 转回子类

        child.parent = "child through field to set parent";// 并不影响前面 parent 的赋值
//        child.setParent("child through method to set child");// 会覆盖掉 child.parent，因为操作的是同一个成员变量

        System.out.println("直接赋值子类的成员变量，并不影响父类的成员变量，查看父类的 parent: \n" + parent.parent);
        System.out.println("查看子类的 parent: \n" + child.parent);

        System.out.println("\n可以把子类的 parent 变量注释掉，发现不论是通过属性直接赋值，还是通过方法赋值，都只会影响到父类的 parent\n");
    }

    static void testMethod() {
    }

    /**
     * 方法的优先级，以子类往父类递减，如果子类没有重写方法，则沿着继承链往父类回溯查找
     */
    static void testPriority() {
        Parent grandson = new Grandson();
        grandson.priority();
    }
}
