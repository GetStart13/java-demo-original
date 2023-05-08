package 时间处理;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        testCalculateMinutesInterval();
    }

    static void testCalculateMinutesInterval() {
        LocalDateTime newest = LocalDateTime.now();
        LocalDateTime old = LocalDateTime.of(2023, 4, 10, 14, 40);
        long between = ChronoUnit.MINUTES.between(old, newest);
        System.out.println(between);
    }
}
