package 时间处理;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 这是旧时间，不建议使用，建议使用新时间
 */
public class DateDemo {
    public static void main(String[] args) {
        Date date = new Date();

        // 获取当前时间，从 1970年1月1日 00:00:00 到现在的毫秒值
        System.out.println(date.getTime());

        // 获取当前时间
        System.out.println(date);

        // 格式化时间，从 Date 格式化为 String
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");
        String dateString = sdf.format(date);
        System.out.println(dateString);

        // 格式化时间，从 String 格式化为 Date
        try {// parse() 可能会有异常，用 try catch 捕获异常
            String dateString1 = "2021年10月18 15:00:00";
            Date date1 = sdf.parse(dateString1);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
