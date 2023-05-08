package StringBuilder类;

import java.util.Scanner;

public class 字符串高级反转 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        String ss = myReverse(line);
        System.out.println(ss);
    }
    public static String myReverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
}
