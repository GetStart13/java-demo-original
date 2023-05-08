package 三个数最值;

import java.util.ArrayList;
import java.util.Scanner;

public class max改进版 {
    public static void main(String[] args) {
        ArrayList<aa> str = new ArrayList<>();
        da(str);
    }

    /*public static void da() {
        int[] ss = {33, 44, 22};
        int a = ss[0];
        for (int s : ss) {
            if (a < s) {
                a = s;
            }
        }
        System.out.println(a);
    }*/
    public static void da(ArrayList<aa> str) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            aa a = new aa();
            a.setSz(sc.nextInt());
            str.add(a);//将输入的数据储存到集合中
        }
        int d = str.get(0).getSz();//将集合str中索引为0的sz的值赋值给d
        for (aa s : str) {//超级遍历，s相当于str.get(i)
            if (d < s.getSz()) {
                d = s.getSz();
            }//如果d小于第i个元素中的sz的值，那么将值赋值给d
        }
        System.out.println(d);
        str.clear();
        //System.out.println(str.get(0).getSz());
    }
}
