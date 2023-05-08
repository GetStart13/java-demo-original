package 集合.List集合.线程安全与否;

import java.util.List;

public class Controller {
    public static void upOne(List<Integer> list) {
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
    }

    public static void upTwo(List<Integer> list) {
        for (int i = 5; i < 10; i++) {
            list.add(i);
        }
    }
}
