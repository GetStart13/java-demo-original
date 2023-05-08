package 时间处理;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 这是旧时间，不建议使用，建议使用新时间
 */
public class DateDemo {
    public static void main(String[] args)  {
        Date d=new Date();

        //获取当前时间，从1970年1月1日00:00:00到现在的毫秒值
        System.out.println(d.getTime());

        //获取当前时间
        System.out.println(d);

        //格式化时间，从Date格式化为String：
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");
        String s = sdf.format(d);
        System.out.println(s);

        //格式化时间，从String格式化为Date：
        try {//parse()可能会有异常，用try catch抛出

        String ss="2021年10月18 15:00:00";
        Date dd = sdf.parse(ss);
        System.out.println(dd);}catch (ParseException e){
            e.printStackTrace();
        }
    }
}
