package 枚举;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.test();
        demo.parseDemo();
    }

    public void test() {
        System.out.println(Week.inCode1(7));
        System.out.println(Week.inCode(3));
        System.out.println(Week.getDay(Week.MONDAY));
        System.out.println(Week.MONDAY);
        System.out.println(Week.MONDAY.getKey());
        System.out.println(Week.values()[1]);
        System.out.println(Arrays.toString(Week.values()));
    }

    public void parseDemo() {
        Sex ss = Sex.MAN.parse("ss");
        System.out.println(ss);
    }
}
