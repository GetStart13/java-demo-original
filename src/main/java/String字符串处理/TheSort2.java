package String字符串处理;

import java.util.Arrays;

public class TheSort2 {
    public static void main(String[] args) {
        String strArr="32 54 65 23 43";
        String[] sta=strArr.split(" ");
        int[] sz=new int[sta.length];
        for (int i=0;i<sta.length;i++){
            sz[i]=Integer.parseInt(sta[i]);
        }
        Arrays.sort(sz);
        //System.out.println(Arrays.toString(sz));
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<sz.length;i++){
            if (i==sz.length-1){sb.append(sz[i]);}
            else {
                sb.append(sz[i]).append(" ");
            }
        }
        String result=sb.toString();
        System.out.println(result);
    }
}
