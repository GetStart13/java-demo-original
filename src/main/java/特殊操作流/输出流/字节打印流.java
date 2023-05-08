package 特殊操作流.输出流;

import java.io.IOException;
import java.io.PrintStream;

public class 字节打印流 {
    public static void main(String[] args) throws IOException {
        PrintStream ps = new PrintStream("ps.txt");
        //写数据
        //字节输出流有的方法
        ps.write(99);//该方法只能输出ASCII编码
        ps.print("\r\n");//换行符

        ps.print(97);
        ps.print("\n");//换行符
        ps.println(99);//输出并换行
        ps.print(98);

        //关闭资源
        ps.close();
    }
}
