package 特殊操作流.输入流;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadFile {
    public ReadFile() {

    }

    // 字节流读取文件
    public void readByBytes() {

        // 获取输入流
        try (FileInputStream inputStream = new FileInputStream("ps.txt")) {
            byte[] bytes1 = inputStream.readAllBytes();
            String string = new String(bytes1, 0, bytes1.length);
            System.out.print("string = " + string);

            // 获取字节流的长度
            /*int available = inputStream.available();
            // 数组缓存区
            byte[] bytes = new byte[available];
            // 将字节流放入缓存区
            int read = inputStream.read(bytes, 0, available);
            System.out.println("bytes = " + Arrays.toString(bytes));
            // 生成字符串
            String str = new String(bytes, 0, read, "gbk");
            System.out.println("read = " + read);
            System.out.println("str = " + str);*/
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 字符流读取文件
    public void readByChar() {

        // 获取输入文件流,使用 BufferedReader 缓存字节流，避免每次读取字符时都从文件中读取，减少开销
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("ps.txt"))) {
            int read;
            while ((read = bufferedReader.read()) != -1) {  // read读取字符，如果已到达流的末尾，则为 -1
                System.out.println("read = " + (char) read);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
