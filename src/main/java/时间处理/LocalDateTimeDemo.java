package 时间处理;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        testCalculateMinutesInterval();
        testLocalDateTimeToLong();
    }

    static void testCalculateMinutesInterval() {
        LocalDateTime newest = LocalDateTime.now();
        LocalDateTime old = LocalDateTime.of(2023, 4, 10, 14, 40);
        long between = ChronoUnit.MINUTES.between(old, newest);
        System.out.println(between);
    }

    /**
     * 将 LocalDateTime 转成时间戳
     */
    static void testLocalDateTimeToLong() {
        LocalDateTime now = LocalDateTime.now();
        // 转系统默认时区
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
        // 转成时间戳，然后根据 1970 年代转成秒
        long convertToMillis = zonedDateTime.toInstant().toEpochMilli();
        System.out.println(convertToMillis);

        // 与系统时间比较
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis);
    }
}
