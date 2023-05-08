package 特殊操作流.输出流;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class 字符打印流 {
    public static void main(String[] args) throws IOException {
        //PrintWrite (String filename)，使用指定的文件名创建一个新的PrintWriter，不会自动刷新
        /*PrintWriter pw=new PrintWriter("pw.txt");

        pw.write("hello");
        pw.write("\r");
        pw.flush();
        pw.write("world");
        pw.write("\r");
        pw.flush();

        pw.println("666");
        pw.println("888");
        pw.flush();*/

        //自动刷新
        PrintWriter pw = new PrintWriter(new FileWriter("pw.txt"), true);
        pw.println("test");
        pw.println("success");
        pw.close();

    }
}
