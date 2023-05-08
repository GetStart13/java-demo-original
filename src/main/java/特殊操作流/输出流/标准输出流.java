package 特殊操作流.输出流;

import java.io.PrintStream;

public class 标准输出流 {
    public static void main(String[] args) {
        PrintStream ps = System.out;//标准输出流
        ps.print("hello");//print()方法中不能没有参数
        ps.println();//println方法中可以没有参数
        System.out.println();//上面两个整合成这个


    }
}
