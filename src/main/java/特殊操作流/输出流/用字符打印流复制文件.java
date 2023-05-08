package 特殊操作流.输出流;

import java.io.*;

public class 用字符打印流复制文件 {
    public static void main(String[] args) throws IOException {
        //输入流，输入文件字符流，并进入缓存区
        BufferedReader br = new BufferedReader(new FileReader("pw.txt"));
        //输出流
        PrintWriter pw = new PrintWriter(new FileWriter("copy.txt"), true);
        String line;
        while ((line = br.readLine()) != null) {//读取每一行并换行
            pw.println(line);
        }
        br.close();
        pw.close();
    }
}
