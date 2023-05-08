package 重载;

/**
 * 重载，方法参数不同，类型不同（即使是父子类也成立），方法名相同
 */
public class Overload {
    private void load(Parent parent) {
        System.out.println(parent);
        System.out.println("parent");
    }

    private void load(Child child) {
        System.out.println(child);
        System.out.println("child");
    }

    private void load(Grandson grandson) {
        System.out.println(grandson);
        System.out.println("grandson");
    }


    public static void main(String[] args) {
        Grandson grandson = new Grandson();
        Overload overload = new Overload();
        overload.load(grandson);
        overload.load((Child) grandson);
        overload.load((Parent) grandson);
    }
}
