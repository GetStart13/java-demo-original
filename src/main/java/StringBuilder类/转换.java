package StringBuilder类;

/*String无法使用StringBuilder中的append方法和reverse方法，所以需要转换*/
public class 转换 {
    public static void main(String[] args) {

        /*StringBuilder转换成String
         * public String toString()通过toString()实现转换*/
        StringBuilder sb = new StringBuilder();
        sb.append("hello");

        /*先创建一个String字符数组空间用于接收转换成的String类型字符*/
        String str = sb.toString();
        System.out.println(str);

        /*String转换成StringBuilder
         * public StringBuilder(String str)通过StringBuilder()方法可以实现转换*/
        StringBuilder sb1 = new StringBuilder(str);
        System.out.println(sb1);
    }
}
