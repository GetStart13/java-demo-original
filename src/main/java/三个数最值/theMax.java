package 三个数最值;

import java.util.Scanner;

public class theMax {
    public static void main(String[] args) {
        int a, b, c;
        /*a=434;b=333;c=654;*/
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        System.out.println(max(a, b, c));
    }

    private static int max(int a,int b,int c) {
        int d = 0;
        if (d < a) {
            d = a;
        }
        if (d < b) {
            d = b;
        }
        if (d < c) {
            d = c;
        }
        return d;
    }
}
