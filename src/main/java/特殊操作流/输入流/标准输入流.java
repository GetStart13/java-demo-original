package 特殊操作流.输入流;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 标准输入流 {
    public static void main(String[] args) throws IOException {
        /*final InputStream in; //标准输入流
        InputStream is = System.in;
        int by;
        while ((by = is.read()) != -1) {
            System.out.println((char) by);
        }
        // 把字节流转换成字符流
        InputStreamReader isr = new InputStreamReader(is);
        int read = isr.read();
        System.out.println("=========" + (char) read);*/
        // 一次读取一行，用字符缓冲输入流的特有方法
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符串:");
        String s = br.readLine();
        System.out.println(s);
        //转换成整数
        System.out.println("int");
        int i = Integer.parseInt(br.readLine());
        System.out.println(i);
        //因为以上步骤太繁琐，java封装了它，写了一个Scanner类
        Scanner sc = new Scanner(System.in);

    }
}
