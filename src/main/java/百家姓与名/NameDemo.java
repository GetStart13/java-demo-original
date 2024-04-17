package 百家姓与名;

public class NameDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(NameUtil.getXing() + NameUtil.getMing());
        }
    }
}
