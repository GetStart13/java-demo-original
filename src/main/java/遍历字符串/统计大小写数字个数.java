package 遍历字符串;

import java.util.Scanner;

public class 统计大小写数字个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();
        int big = 0;
        int small = 0;
        int number = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') {
                big++;
            } else if (line.charAt(i) >= 'a' && line.charAt(i) <= 'z') {
                small++;
            } else if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                number++;
            }
        }
        System.out.println("大写字母：" + big + "" + "  小写字母：" + small + " " + " 数字：" + number);
    }
}
