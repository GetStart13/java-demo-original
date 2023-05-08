package 特殊操作流.Scanner的使用;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 声明有两个 int 变量意味着控制台需要输入两个 int 参数；空格会自动为两个整数分隔，也可以用回车分隔；
            int i1 = scanner.nextInt();
            int i2 = scanner.nextInt();
            // nextLine 为读取整行输入内容，这里 i1 与 s1 衔接，在输入 i1 后使用空格分隔的输入内容就是 s1 的内容，不输入则 s1 为空
            // 因为 nextLine 是整行读取，所以 s2 要以回车分隔；
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            // next 也是按空格分隔，因此输入 s3 s4 时按空格分隔；
            String s3 = scanner.next();
            String s4 = scanner.next();

            System.out.println("i1 = " + i1);
            System.out.println("i2 = " + i2);
            System.out.println("s1 = " + s1);
            System.out.println("s2 = " + s2);
            System.out.println("s3 = " + s3);
            System.out.println("s4 = " + s4);
        }
    }
}
